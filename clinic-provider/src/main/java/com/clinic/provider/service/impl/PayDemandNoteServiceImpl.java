package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.dto.PayDemandNoteDto;
import com.clinic.provider.domain.entity.CostDetails;
import com.clinic.provider.domain.entity.PayDemandNote;
import com.clinic.provider.domain.vo.PayDemandNoteVo;
import com.clinic.provider.mapper.CostDetailsMapper;
import com.clinic.provider.mapper.PayDemandNoteMapper;
import com.clinic.provider.service.PayDemandNoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author majunjie
 * @since 2021-03-05
 */
@Service
@Slf4j
public class PayDemandNoteServiceImpl extends ServiceImpl<PayDemandNoteMapper, PayDemandNote> implements PayDemandNoteService {

    @Autowired
    private PayDemandNoteMapper payDemandNoteMapper;

    @Autowired
    private CostDetailsMapper costDetailsMapper;

    @Override
    public JSONObject saveOrUpdatePayDemandNote(PayDemandNoteDto payDemandNoteDto) {
        //获取收费单
        PayDemandNote payDemandNote = payDemandNoteDto.getPayDemandNote();
        List<CostDetails> costDetailsList = payDemandNoteDto.getCostDetailsList();
        Integer id = payDemandNote.getId();
        //判断是否是新增
        try {
            if (id == null) {
                //保存相关的申请单
                payDemandNoteMapper.insert(payDemandNote);
                //获取id
                Integer afterId = payDemandNote.getId();
                for (CostDetails costDetail : costDetailsList) {
                    costDetail.setPayDemandId(afterId);
                    //防止已经保存过的插入
                    if (costDetail.getId() != null) {
                        continue;
                    }
                    costDetailsMapper.insert(costDetail);
                }
                return RenderResultUtil.renderSuccess("新增成功");
            } else {
                QueryWrapper<PayDemandNote> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("id", id);
                payDemandNoteMapper.update(payDemandNote, queryWrapper);
                QueryWrapper<CostDetails> wrapper = new QueryWrapper<>();
                wrapper.eq("pay_demand_id", id);
                costDetailsMapper.delete(wrapper);
                for (CostDetails costDetail : costDetailsList) {
                    costDetail.setPayDemandId(id);
                    //防止已经保存过的插入
//                    if (costDetail.getId()!=null){
//                        continue;
//                    }
                    costDetailsMapper.insert(costDetail);
                }
                return RenderResultUtil.renderSuccess("修改成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("修改失败");
        }


    }

    @Override
    public JSONObject deletePayDemandNote(String id) {
        QueryWrapper<PayDemandNote> queryWrapper = new QueryWrapper();
        QueryWrapper<CostDetails> wrapper = new QueryWrapper<>();
        try {
            wrapper.eq("pay_demand_id", id);
            costDetailsMapper.delete(wrapper);
            queryWrapper.eq("id", id);
            payDemandNoteMapper.delete(queryWrapper);
            return RenderResultUtil.renderSuccess("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("保存失败");
        }

    }

    @Override
    public JSONObject getPayDemandNote(String patientId, String visitId, String hospCode) {
        QueryWrapper<PayDemandNote> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId).eq("visit_id", visitId).eq("hosp_code", hospCode);
        List<PayDemandNote> payDemandNotes = payDemandNoteMapper.selectList(queryWrapper);
        PayDemandNoteVo payDemandNoteVo = new PayDemandNoteVo();
        if (CollectionUtils.isEmpty(payDemandNotes)) {
            return RenderResultUtil.success("查询成功", payDemandNoteVo);
        }
        PayDemandNote payDemandNote = payDemandNotes.get(0);
        Integer id = payDemandNote.getId();
        payDemandNoteVo.setPayDemandNote(payDemandNote);
        QueryWrapper<CostDetails> wrapper = new QueryWrapper();
        wrapper.eq("pay_demand_id", id);
        List<CostDetails> costDetails = costDetailsMapper.selectList(wrapper);
        payDemandNoteVo.setCostDetailsList(costDetails);
        return RenderResultUtil.success("查询成功", payDemandNoteVo);
    }
}

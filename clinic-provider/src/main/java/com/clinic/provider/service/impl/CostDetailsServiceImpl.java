package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.domain.entity.CostDetails;
import com.clinic.provider.domain.entity.PayDemandNote;
import com.clinic.provider.domain.vo.PayDemandNoteVo;
import com.clinic.provider.mapper.CostDetailsMapper;
import com.clinic.provider.mapper.PayDemandNoteMapper;
import com.clinic.provider.service.CostDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class CostDetailsServiceImpl extends ServiceImpl<CostDetailsMapper, CostDetails> implements CostDetailsService {

    @Autowired
    private CostDetailsMapper costDetailsMapper;

    @Autowired
    private PayDemandNoteMapper payDemandNoteMapper;

    @Override
    public JSONObject getCostDetails(String patientId, String visitId, String hospCode) {
        QueryWrapper<CostDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId).eq("visit_id", visitId).eq("hosp_code", hospCode);
        List<CostDetails> costDetails = costDetailsMapper.selectList(queryWrapper);
        QueryWrapper<PayDemandNote> wrapper = new QueryWrapper<>();
        wrapper.eq("patient_id", patientId).eq("visit_id", visitId).eq("hosp_code", hospCode);
        PayDemandNote payDemandNote = payDemandNoteMapper.selectList(wrapper).get(0);
        PayDemandNoteVo payDemandNoteVo = new PayDemandNoteVo();
        payDemandNoteVo.setPayDemandNote(payDemandNote);
        payDemandNoteVo.setCostDetailsList(costDetails);
        return RenderResultUtil.success("查询成功", payDemandNoteVo);
    }

    @Override
    public JSONObject getCostDetailsList(String patientId, String hospCode) {
//        QueryWrapper<CostDetails> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("patient_id",patientId).eq("visit_id",visitId).eq("hosp_code",hospCode);
//        List<CostDetails> costDetails = costDetailsMapper.selectList(queryWrapper);
        List<PayDemandNoteVo> pv = new ArrayList<>();
        QueryWrapper<PayDemandNote> wrapper = new QueryWrapper<>();
        wrapper.eq("patient_id", patientId).eq("hosp_code", hospCode);
        List<PayDemandNote> payDemandNotes = payDemandNoteMapper.selectList(wrapper);
        for (PayDemandNote payDemandNote : payDemandNotes) {
            PayDemandNoteVo payDemandNoteVo = new PayDemandNoteVo();
            payDemandNoteVo.setPayDemandNote(payDemandNote);
            String visitId = payDemandNote.getVisitId();
            QueryWrapper<CostDetails> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("patient_id", patientId).eq("visit_id", visitId).eq("hosp_code", hospCode);
            List<CostDetails> costDetails = costDetailsMapper.selectList(queryWrapper);
            payDemandNoteVo.setCostDetailsList(costDetails);
            pv.add(payDemandNoteVo);
        }

        return RenderResultUtil.success("查询成功", pv);

    }
}

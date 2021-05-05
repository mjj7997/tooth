package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.api.CommonResult;
import com.clinic.provider.domain.dto.CaseHistoryDto;
import com.clinic.provider.domain.dto.GetCaseHistoryDto;
import com.clinic.provider.domain.entity.CaseHistory;
import com.clinic.provider.mapper.CaseHistoryMapper;
import com.clinic.provider.service.CaseHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
 * @since 2021-02-21
 */
@Service
@Slf4j
public class CaseHistoryServiceImpl extends ServiceImpl<CaseHistoryMapper, CaseHistory> implements CaseHistoryService {


    @Autowired
    private CaseHistoryMapper caseHistoryMapper;

    @Override
    public JSONObject saveOrUpdateCaseHistory(CaseHistoryDto caseHistoryDto) {
        CaseHistory caseHistory = new CaseHistory();
        BeanUtils.copyProperties(caseHistoryDto, caseHistory);
        Integer id = caseHistory.getId();
        try {
            if (id != null) {
                QueryWrapper<CaseHistory> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("id", id);
                caseHistoryMapper.update(caseHistory, queryWrapper);
            } else {
                caseHistoryMapper.insert(caseHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("回滚!!!");
            return RenderResultUtil.renderError("保存失败");
        }

        return RenderResultUtil.renderSuccess("编辑成功");
    }

    @Override
    public JSONObject getCaseHistoryById(GetCaseHistoryDto caseHistoryDto) {
        String patientId = caseHistoryDto.getPatientId();
        String visitId = caseHistoryDto.getVisitId();
        String hospCode = caseHistoryDto.getHospCode();
        QueryWrapper<CaseHistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId).eq("visit_id", visitId).eq("hosp_code", hospCode);
        List<CaseHistory> caseHistories = caseHistoryMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(caseHistories)) {
            CaseHistory caseHistory = new CaseHistory();
            JSONObject jsonObject = RenderResultUtil.error("查询结果为空", caseHistory);
            return jsonObject;
        } else {
            return RenderResultUtil.success("查询成功", caseHistories.get(0));
        }
    }

    @Override
    public CommonResult<CaseHistory> getCaseHistoryById1(GetCaseHistoryDto caseHistoryDto) {
        String patientId = caseHistoryDto.getPatientId();
        String visitId = caseHistoryDto.getVisitId();
        String hospCode = caseHistoryDto.getHospCode();
        QueryWrapper<CaseHistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId).eq("visit_id", visitId).eq("hosp_code", hospCode);
        List<CaseHistory> caseHistories = caseHistoryMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(caseHistories)) {
            CaseHistory caseHistory = new CaseHistory();
            CommonResult<CaseHistory> success = CommonResult.success(caseHistory);
            return success;
        } else {
            return CommonResult.success(caseHistories.get(0));
        }

    }

    @Override
    public JSONObject getCaseHistoryByPatientId(GetCaseHistoryDto caseHistoryDto) {
        String patientId = caseHistoryDto.getPatientId();
        String visitId = caseHistoryDto.getVisitId();
        String hospCode = caseHistoryDto.getHospCode();
        QueryWrapper<CaseHistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId).eq("hosp_code", hospCode);
        List<CaseHistory> caseHistories = caseHistoryMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(caseHistories)) {
            CaseHistory caseHistory = new CaseHistory();
            JSONObject jsonObject = RenderResultUtil.error("查询结果为空", caseHistory);
            return jsonObject;
        } else {
            return RenderResultUtil.success("查询成功", caseHistories);
        }

    }
}

package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.api.CommonResult;
import com.clinic.provider.domain.dto.CaseHistoryDto;
import com.clinic.provider.domain.dto.GetCaseHistoryDto;
import com.clinic.provider.domain.entity.CaseHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-21
 */
public interface CaseHistoryService extends IService<CaseHistory> {

    JSONObject saveOrUpdateCaseHistory(CaseHistoryDto caseHistoryDto);

    JSONObject getCaseHistoryById(GetCaseHistoryDto caseHistoryDto);

    CommonResult<CaseHistory> getCaseHistoryById1(GetCaseHistoryDto caseHistoryDto);


}

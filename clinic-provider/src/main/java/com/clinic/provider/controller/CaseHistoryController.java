package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.api.CommonResult;
import com.clinic.provider.domain.dto.CaseHistoryDto;
import com.clinic.provider.domain.dto.GetCaseHistoryDto;
import com.clinic.provider.domain.entity.CaseHistory;
import com.clinic.provider.service.CaseHistoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/caseHistory")
public class CaseHistoryController {

    @Autowired
    private CaseHistoryService caseHistoryService;

    @PostMapping("saveOrUpdateCaseHistory")
    @ApiOperation(value = "saveOrUpdateCaseHistory（更新病历如果初次保存id需要为空，如果更新id不能为空）", httpMethod = "POST")
    public JSONObject saveOrUpdateCaseHistory(@RequestBody CaseHistoryDto caseHistoryDto) {

        return caseHistoryService.saveOrUpdateCaseHistory(caseHistoryDto);
    }

    @PostMapping("getCaseHistoryById")
    @ApiOperation(value = "getCaseHistoryById（获取病历信息，如果id不为空，展示数据由我后端提供）", httpMethod = "POST")
    public JSONObject getCaseHistoryById(@RequestBody GetCaseHistoryDto getCaseHistoryDto) {

        return caseHistoryService.getCaseHistoryById(getCaseHistoryDto);
    }

    @PostMapping("getCaseHistoryById1")
    @ApiOperation(value = "getCaseHistoryById1（获取病历信息，如果id不为空，展示数据由我后端提供）", httpMethod = "POST")
    public CommonResult<CaseHistory> getCaseHistoryById1(@RequestBody GetCaseHistoryDto getCaseHistoryDto) {

        return caseHistoryService.getCaseHistoryById1(getCaseHistoryDto);
    }

    @PostMapping("getCaseHistoryByPatientId")
    @ApiOperation(value = "getCaseHistoryByPatientId（获取历次病历信息，如果id不为空，展示数据由我后端提供）", httpMethod = "POST")
    public JSONObject getCaseHistoryByPatientId(@RequestBody GetCaseHistoryDto getCaseHistoryDto) {

        return caseHistoryService.getCaseHistoryByPatientId(getCaseHistoryDto);
    }
}


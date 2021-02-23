package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.CaseHistoryDto;
import com.clinic.provider.domain.dto.GetCaseHistoryDto;
import com.clinic.provider.service.CaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
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
    public JSONObject saveOrUpdateCaseHistory(@RequestBody CaseHistoryDto caseHistoryDto){

        return caseHistoryService.saveOrUpdateCaseHistory(caseHistoryDto);
    }

    @PostMapping("getCaseHistoryById")
    public JSONObject getCaseHistoryById(@RequestBody GetCaseHistoryDto getCaseHistoryDto){

        return caseHistoryService.getCaseHistoryById(getCaseHistoryDto);
    }
}


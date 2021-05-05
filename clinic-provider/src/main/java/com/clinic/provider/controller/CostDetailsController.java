package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.service.CostDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/costDetails")
@Api(value = "单独操作计价费用api", tags = {"单独操作计价费用api"})
public class CostDetailsController {

    @Autowired
    private CostDetailsService costDetailsService;


    @PostMapping("getCostDetails")
    @ApiOperation(value = "getCostDetailsList（获取单个收费单结果）", httpMethod = "POST")
    public JSONObject getCostDetails(@RequestParam("patientId") String patientId, @RequestParam("visitId") String visitId, @RequestParam("hospCode") String hospCode) {
        return costDetailsService.getCostDetails(patientId, visitId, hospCode);
    }

    @PostMapping("getCostDetailsList")
    @ApiOperation(value = "getCostDetailsList（获取所有收费单结果）", httpMethod = "POST")
    public JSONObject getCostDetailsList(@RequestParam("patientId") String patientId, @RequestParam("hospCode") String hospCode) {
        return costDetailsService.getCostDetailsList(patientId, hospCode);
    }

}


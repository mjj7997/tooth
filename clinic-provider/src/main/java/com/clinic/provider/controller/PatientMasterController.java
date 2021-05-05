package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.GetPantientDto;
import com.clinic.provider.domain.dto.PatientMasterDto;
import com.clinic.provider.service.PatientMasterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
@RestController
@RequestMapping("/patientMaster")
@Api(value = "患者主信息api", tags = {"患者主信息api"})
public class PatientMasterController {


    @Autowired
    private PatientMasterService patientMasterService;


    @PostMapping("getpatientId")
    @ApiOperation(value = "getpatientId", httpMethod = "POST")
    public JSONObject getpatientId() {
        return patientMasterService.getpatientId();
    }


    @PostMapping("savePatientMaster")
    @ApiOperation(value = "savePatientMaster", httpMethod = "POST")
    public JSONObject savePatientMaster(@RequestBody PatientMasterDto patientMasterDto) {
        JSONObject jsonObject = patientMasterService.savePatientMaster(patientMasterDto);
        return jsonObject;
    }

    @PostMapping("getPatientMasterByDto")
    @ApiOperation(value = "getPatientMasterByDto", httpMethod = "POST")
    public JSONObject getPatientMasterByDto(@RequestBody GetPantientDto getPantientDto) {
        JSONObject jsonObject = patientMasterService.getPatientMasterByDto(getPantientDto);
        return jsonObject;
    }

}


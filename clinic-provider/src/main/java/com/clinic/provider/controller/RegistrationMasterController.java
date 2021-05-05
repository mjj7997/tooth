package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.GetRegistrationByIdDto;
import com.clinic.provider.domain.dto.GetRegistrationByPatientIdDto;
import com.clinic.provider.domain.dto.SaveRegistrationDto;
import com.clinic.provider.domain.dto.UpdateRegistrationStatusDto;
import com.clinic.provider.service.RegistrationMasterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
@RestController
@RequestMapping("/registrationMaster")
@Api(value = "挂号api", tags = {"挂号api"})
public class RegistrationMasterController {

    @Autowired
    private RegistrationMasterService registrationMasterService;


    @PostMapping("saveRegistrationMaster")
    @ApiOperation(value = "saveRegistrationMaster", httpMethod = "POST")
    public JSONObject saveRegistrationMaster(@RequestBody SaveRegistrationDto saveRegistrationDto) {
        return registrationMasterService.saveRegistrationMaster(saveRegistrationDto);
    }


    @PostMapping("getRegistrationMaster")
    @ApiOperation(value = "getRegistrationMaster", httpMethod = "POST")
    public JSONObject getRegistrationMaster(@RequestParam("hospCode") String hospCode) {
        return registrationMasterService.getRegistrationMaster(hospCode);
    }

    @PostMapping("getHeadline")
    @ApiOperation(value = "getHeadline(获取标题，新患者人数)", httpMethod = "POST")
    public JSONObject getHeadline(@RequestParam("hospCode") String hospCode) {
        return registrationMasterService.getHeadline(hospCode);
    }

    @PostMapping("getRegistrationById")
    @ApiOperation(value = "getRegistrationById(获取患者个人信息)", httpMethod = "POST")
    public JSONObject getRegistrationById(@RequestBody GetRegistrationByIdDto getRegistrationByIdDto) {
        return registrationMasterService.getRegistrationById(getRegistrationByIdDto);
    }


    @PostMapping("updateRegistrationStatus")
    @ApiOperation(value = "updateRegistrationStatus(修改就诊状态)", httpMethod = "POST")
    public JSONObject updateRegistrationStatus(@RequestBody UpdateRegistrationStatusDto updateRegistrationStatusDto) {
        return registrationMasterService.updateRegistrationStatus(updateRegistrationStatusDto);
    }

    @PostMapping("getRegistrationByPatientId")
    @ApiOperation(value = "getRegistrationByPatientId(获取患者历次就诊个人信息)", httpMethod = "POST")
    public JSONObject getRegistrationByPatientId(@RequestBody GetRegistrationByPatientIdDto getRegistrationByPatientIdDto) {
        return registrationMasterService.getRegistrationByPatientId(getRegistrationByPatientIdDto);
    }
}


package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.SaveRegistrationDto;
import com.clinic.provider.service.RegistrationMasterService;
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
 *  前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
@RestController
@RequestMapping("/registrationMaster")
@Api(value = "挂号api",tags = {"挂号api"})
public class RegistrationMasterController {

    @Autowired
    private RegistrationMasterService registrationMasterService;


    @PostMapping("saveRegistrationMaster")
    @ApiOperation(value = "saveRegistrationMaster",httpMethod = "POST")
    public JSONObject saveRegistrationMaster(@RequestBody SaveRegistrationDto saveRegistrationDto){
        return registrationMasterService.saveRegistrationMaster(saveRegistrationDto);
    }


    @PostMapping("getRegistrationMaster")
    @ApiOperation(value = "getRegistrationMaster",httpMethod = "POST")
    public JSONObject getRegistrationMaster(){
        return registrationMasterService.getRegistrationMaster();
    }

    @PostMapping("getHeadline")
    @ApiOperation(value = "getHeadline(获取标题，新患者人数)",httpMethod = "POST")
    public JSONObject getHeadline(){
        return registrationMasterService.getHeadline();
    }
}


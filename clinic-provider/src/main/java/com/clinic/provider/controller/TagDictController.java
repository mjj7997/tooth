package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.TagListDto;
import com.clinic.provider.service.TagDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
@RestController
@RequestMapping("/tagDict")
@Api(value = "标签api",tags = {"标签api"})
public class TagDictController {

    @Autowired
    private TagDictService tagDictService;


    @PostMapping("getPatientTag")
    @ApiOperation(value = "getPatientTag",httpMethod = "POST")
    public JSONObject getPatientTag(@RequestParam("hospCode") String hospCode){
        return tagDictService.getPatientTag(hospCode);
    }

    @PostMapping("getRegistrationTag")
    @ApiOperation(value = "getRegistrationTag",httpMethod = "POST")
    public JSONObject getRegistrationTag(@RequestBody TagListDto tagListDto){
        return tagDictService.getRegistrationTag(tagListDto);
    }

}


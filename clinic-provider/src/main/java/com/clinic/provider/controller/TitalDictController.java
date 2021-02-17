package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.common.utils.JsonResult;
import com.clinic.provider.domain.dto.TitalDictDto;
import com.clinic.provider.domain.entity.TitalDict;
import com.clinic.provider.service.TitalDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-02-12
 */
@RestController
@RequestMapping("/titalDict")
@Api(value = "就诊事项api",tags = {"就诊事项api"})
public class TitalDictController {

    @Autowired
    private TitalDictService titalDictService;

    @PostMapping("saveTitalDict")
    @ApiOperation(value = "saveTitalDict",httpMethod = "POST")
    public JSONObject saveTitalDict(@RequestBody TitalDictDto titalDictDto){
        return titalDictService.saveTitalDict(titalDictDto);
    }


    @PostMapping("deleteTitalDict")
    @ApiOperation(value = "deleteTitalDict",httpMethod = "POST")
    public JSONObject deleteTitalDict(@RequestParam Integer id){
        return titalDictService.deleteTitalDict(id);
    }

    @PostMapping("updateTitalDict")
    @ApiOperation(value = "updateTitalDict（修改子集）",httpMethod = "POST")
    public JSONObject updateTitalDict(@RequestBody TitalDictDto titalDictDto){
        return titalDictService.updateTitalDict(titalDictDto);
    }
}


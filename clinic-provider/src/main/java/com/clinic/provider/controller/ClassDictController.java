package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.SaveClassDictDto;
import com.clinic.provider.service.ClassDictService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-03-02
 */
@RestController
@RequestMapping("/classDict")
@Api(value = "费用分类api",tags = {"费用分类api"})
public class ClassDictController {

    @Autowired
    private ClassDictService classDictService;

    @PostMapping("getClassDict")
    public JSONObject getClassDict(@RequestParam("hospCode") String hospCode){
        return classDictService.getClassDict(hospCode);
    }

    @PostMapping("saveOrUpdateClassDict")
    public JSONObject saveOrUpdateClassDict(@RequestBody SaveClassDictDto saveClassDictDto){
        return classDictService.saveOrUpdateClassDict(saveClassDictDto);
    }

    @PostMapping("deleteClassDictById")
    public JSONObject deleteClassDictById(@RequestParam("id") Integer id){
        return classDictService.deleteClassDictById(id);
    }

    @PostMapping("getMenuList")
    public JSONObject getMenuList(@RequestParam("hospCode")String hospCode){
        return classDictService.getMenuList(hospCode);
    }
}


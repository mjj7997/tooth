package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.SelectStaffDto;
import com.clinic.provider.domain.dto.StaffDictDto;
import com.clinic.provider.service.StaffDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-01-22
 */
@RestController
@RequestMapping("/staffDict")
@Api(value = "职工管理api", tags = {"职工管理api"})
public class StaffDictController {

    @Autowired
    private StaffDictService staffDictService;

    @ApiOperation(value = "saveStaffDict", httpMethod = "POST")
    @PostMapping("saveStaffDict")
    public JSONObject saveStaffDict(@RequestBody StaffDictDto staffDictDto) {

        JSONObject jsonObject = staffDictService.saveStaffDict(staffDictDto);
        return jsonObject;
    }

    @ApiOperation(value = "getStaffDict", httpMethod = "POST")
    @PostMapping("getStaffDict")
    public JSONObject getStaffDict(@RequestBody SelectStaffDto selectStaffDto) {

        JSONObject jsonObject = staffDictService.getStaffDict(selectStaffDto);
        return jsonObject;
    }

    @ApiOperation(value = "getStaffDictByUser", httpMethod = "POST")
    @PostMapping("getStaffDictByUser")
    public JSONObject getStaffDictByUser(@RequestParam("userId") String userId) {

        JSONObject jsonObject = staffDictService.getStaffDictByUser(userId);
        return jsonObject;
    }

    @ApiOperation(value = "delStaffDictById", httpMethod = "POST")
    @PostMapping("delStaffDictById")
    public JSONObject delStaffDictById(@RequestParam("id") Integer id) {

        JSONObject jsonObject = staffDictService.delStaffDictById(id);
        return jsonObject;
    }

    @ApiOperation(value = "updateStaffDictById", httpMethod = "POST")
    @PostMapping("updateStaffDictById")
    public JSONObject updateStaffDictById(@RequestBody StaffDictDto staffDictDto) {

        JSONObject jsonObject = staffDictService.updateStaffDictById(staffDictDto);
        return jsonObject;
    }
}


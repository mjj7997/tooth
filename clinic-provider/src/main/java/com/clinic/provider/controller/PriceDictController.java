package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.SavePriceDictDto;
import com.clinic.provider.service.PriceDictService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-03-02
 */
@RestController
@RequestMapping("/priceDict")
@Api(value = "价表维护api",tags = {"价表维护api"})
public class PriceDictController {

    @Autowired
    private PriceDictService priceDictService;

    @PostMapping("getPriceDictByClassId")
    public JSONObject getPriceDictByClassId(@RequestParam("classId")String classId,@RequestParam("input")String input,@RequestParam("hospCode")String hospCode){
        return priceDictService.getPriceDictByClassId(classId,input,hospCode);
    }

    @PostMapping("saveOrUpdatePriceDict")
    public JSONObject saveOrUpdatePriceDict(@RequestBody SavePriceDictDto savePriceDictDto){
        return priceDictService.saveOrUpdatePriceDict(savePriceDictDto);
    }

    @PostMapping("deletePriceDictById")
    public JSONObject deletePriceDictById(@RequestParam("id") String id){
        return priceDictService.deletePriceDictById(id);
    }

}


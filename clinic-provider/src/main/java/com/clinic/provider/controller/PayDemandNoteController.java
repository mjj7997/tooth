package com.clinic.provider.controller;


import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.PayDemandNoteDto;
import com.clinic.provider.service.PayDemandNoteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author majunjie
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/payDemandNote")
@Api(value = "收费单api", tags = {"收费单api"})
public class PayDemandNoteController {

    @Autowired
    private PayDemandNoteService payDemandNoteService;


    @PostMapping("saveOrUpdatePayDemandNote")
    public JSONObject saveOrUpdatePayDemandNote(@RequestBody PayDemandNoteDto payDemandNoteDto) {
        return payDemandNoteService.saveOrUpdatePayDemandNote(payDemandNoteDto);
    }

    @PostMapping("deletePayDemandNote")
    public JSONObject deletePayDemandNote(@RequestParam("id") String id) {
        return payDemandNoteService.deletePayDemandNote(id);
    }

    @PostMapping("getPayDemandNote")
    public JSONObject getPayDemandNote(@RequestParam("patientId") String patientId, @RequestParam("visitId") String visitId, @RequestParam("hospCode") String hospCode) {
        return payDemandNoteService.getPayDemandNote(patientId, visitId, hospCode);
    }
}


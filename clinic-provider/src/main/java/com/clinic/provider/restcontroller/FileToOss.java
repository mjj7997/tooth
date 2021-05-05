package com.clinic.provider.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.service.IOssService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: majunjie
 * @Date: 2021年3月8日$ 02点40分$
 * @Description:
 */
@RestController
@RequestMapping
public class FileToOss {

    @Autowired
    private IOssService iOssService;

    @PostMapping("uploadPicOss")
    public JSONObject fileUpload(@RequestParam("files") MultipartFile files) {

        return iOssService.uploadPicOss(files);

    }
}

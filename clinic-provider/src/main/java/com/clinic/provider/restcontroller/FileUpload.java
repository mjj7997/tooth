package com.clinic.provider.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.clinic.common.utils.PathUtils;
import com.clinic.common.utils.RenderResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author: majunjie
 * @Date: 2021年2月23日$ 10点01分$
 * @Description:
 */
@RestController
@RequestMapping
@Slf4j
public class FileUpload {

    @Value("${real.path}")
    private String realPath;


    @PostMapping("fileUpload")
    public JSONObject fileUpload(@RequestParam("files") MultipartFile files) {
        if (files.isEmpty()) {
            return RenderResultUtil.renderError("文件不能为空");
        }
        File file = new File(realPath);
        if (!file.isDirectory()) {
            file.mkdir();
        }
        String name = files.getOriginalFilename();
        //处理过后的文件名称
        String fileName = UUID.randomUUID() + PathUtils.getFlieSuffixName(name);
        //保存后的绝对路径
        String path = realPath + fileName;
        try {
            Path path1 = Paths.get(path);
            files.transferTo(path1);
        } catch (Exception e) {
            e.printStackTrace();
            return RenderResultUtil.renderError("保存失败");
        }
        return RenderResultUtil.success("保存成功", fileName);
    }
}

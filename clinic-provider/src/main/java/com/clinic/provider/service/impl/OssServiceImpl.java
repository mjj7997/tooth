package com.clinic.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.clinic.common.utils.PathUtils;
import com.clinic.common.utils.RenderResultUtil;
import com.clinic.provider.service.IOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author: majunjie
 * @Date: 2021年3月8日$ 02点30分$
 * @Description:
 */
@Service
public class OssServiceImpl implements IOssService {

    @Value("${oss.bucketName}")
    private String bucketName;

    @Value("${oss.endpoint}")
    private String endPoint;

    @Autowired
    private OSSClient ossClient;


    @Override
    public JSONObject uploadPicOss(MultipartFile files) {
        if (files.isEmpty()) {
            return RenderResultUtil.renderError("文件不能为空");
        }
        String name = files.getOriginalFilename();
        //处理过后的文件名称
        String fileName = UUID.randomUUID() + PathUtils.getFlieSuffixName(name);
        //保存后的绝对路径
        String path;
        try {
            path = uploadToOss(fileName, new ByteArrayInputStream(files.getBytes()));

        } catch (Exception e) {
            e.printStackTrace();
            return RenderResultUtil.renderError("保存失败");
        }
        return RenderResultUtil.success("保存成功", path);
    }

    /**
     * 上传图片
     *
     * @param fileName 图片名称，图片名称包括文件夹名称和“/”
     * @param in       图片输入流
     */
    private String uploadToOss(String fileName, InputStream in) {
        // 上传Object.
        PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, in);
        //返回oss服务器访问上传图片的url
        return "https://" + bucketName + "." + endPoint + "/" + fileName;
    }


}

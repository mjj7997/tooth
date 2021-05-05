package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: majunjie
 * @Date: 2021年3月8日$ 02点28分$
 * @Description:
 */

public interface IOssService {

    /**
     * 上传图片到OSS服务器
     *
     * @return oss服务器图片访问url
     */
    JSONObject uploadPicOss(MultipartFile files);
}

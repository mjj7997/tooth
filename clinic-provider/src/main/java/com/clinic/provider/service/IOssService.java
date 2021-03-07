package com.clinic.provider.service;

/**
 * @author: majunjie
 * @Date: 2021年3月8日$ 02点28分$
 * @Description:
 */
public interface IOssService {

    /**
     * 上传图片到OSS服务器
     * @return oss服务器图片访问url
     */
    String uploadPicOss();
}

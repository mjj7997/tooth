package com.clinic.provider.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: majunjie
 * @Date: 2021年3月8日$ 02点03分$
 * @Description:
 */
@Configuration
public class OssConfig {

    @Value("${oss.endpoint}")
    private String endPoint;

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;


    /**
     * 定义ossClient bean对象
     */
    @Bean
    public OSSClient ossClient() {
        return new OSSClient(endPoint, accessKeyId, accessKeySecret);
    }
}

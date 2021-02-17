package com.clinic.provider.domain.dto;

import lombok.Data;

@Data
public class LoginDto {

    /**
     * 员工工号
     */
    private String userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 医院代码
     */
    private String hospCode;
}

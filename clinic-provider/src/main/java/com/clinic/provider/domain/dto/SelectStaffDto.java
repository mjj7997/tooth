package com.clinic.provider.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: majunjie
 * @Date: 2021年1月25日$ 01点19分$
 * @Description:
 */
@Data
public class SelectStaffDto implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 状态，启用-0，停用-1，默认围空
     */
    private Integer status;

    /**
     * 医院代码
     */
    private String hospCode;

    /**
     * 输入
     */
    private String input;


}

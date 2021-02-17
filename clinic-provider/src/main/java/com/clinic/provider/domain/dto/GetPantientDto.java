package com.clinic.provider.domain.dto;

import lombok.Data;

/**
 * @author: majunjie
 * @Date: 2021年2月11日$ 18点26分$
 * @Description:
 */
@Data
public class GetPantientDto {

    /**
     * 姓名/病历号/手机号
     */
    private String input;

    /**
     * 获取病人状态
     */
    private Integer selectStatus;

    /**
     * 医院代码
     */
    private String hospCode;

}

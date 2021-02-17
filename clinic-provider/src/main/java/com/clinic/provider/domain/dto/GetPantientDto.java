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
     *
     */
    private Integer selectStatus;

}

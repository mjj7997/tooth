package com.clinic.provider.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: majunjie
 * @Date: 2021年2月15日$ 10点35分$
 * @Description:
 */
@Data
public class HeadlineVo implements Serializable {

    private static final long serialVersionUID=1L;

    private int registration;

    private int patient;
}

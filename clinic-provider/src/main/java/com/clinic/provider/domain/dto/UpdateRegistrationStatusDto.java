package com.clinic.provider.domain.dto;

import lombok.Data;

/**
 * @author: majunjie
 * @Date: 2021年2月18日$ 00点26分$
 * @Description:
 */
@Data
public class UpdateRegistrationStatusDto {

    private String patientId;

    private String visitId;

    private String hospCode;

    /**
     * 1-候诊中  2-治疗中  3-已完成
     */
    private Integer clinicState;
}

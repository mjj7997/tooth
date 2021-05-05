package com.clinic.provider.domain.dto;

import lombok.Data;

/**
 * @author: majunjie
 * @Date: 2021年3月11日$ 23点44分$
 * @Description:
 */
@Data
public class GetRegistrationByPatientIdDto {

    private String patientId;


    private String hospCode;
}

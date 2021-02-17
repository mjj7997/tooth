package com.clinic.provider.domain.dto;

import lombok.Data;

/**
 * @author: majunjie
 * @Date: 2021年2月18日$ 00点01分$
 * @Description:
 */
@Data
public class GetRegistrationByIdDto {

    private String patientId;

    private String visitId;

    private String hospCode;
}

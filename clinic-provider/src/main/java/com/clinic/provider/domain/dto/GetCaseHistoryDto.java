package com.clinic.provider.domain.dto;

import lombok.Data;

/**
 * @author: majunjie
 * @Date: 2021年2月23日$ 15点23分$
 * @Description:
 */
@Data
public class GetCaseHistoryDto {

    private String patientId;

    private String visitId;

    private String hospCode;
}

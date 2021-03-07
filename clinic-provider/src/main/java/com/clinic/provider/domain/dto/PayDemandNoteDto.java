package com.clinic.provider.domain.dto;

import com.clinic.provider.domain.entity.CostDetails;
import com.clinic.provider.domain.entity.PayDemandNote;
import lombok.Data;

import java.util.List;

/**
 * @author: majunjie
 * @Date: 2021年3月5日$ 11点27分$
 * @Description:
 */
@Data
public class PayDemandNoteDto {

    private PayDemandNote payDemandNote;

    private List<CostDetails> costDetailsList;

}

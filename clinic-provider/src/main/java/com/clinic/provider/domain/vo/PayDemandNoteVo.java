package com.clinic.provider.domain.vo;

import com.clinic.provider.domain.entity.CostDetails;
import com.clinic.provider.domain.entity.PayDemandNote;
import lombok.Data;

import java.util.List;

/**
 * @author: majunjie
 * @Date: 2021年3月5日$ 15点50分$
 * @Description:
 */
@Data
public class PayDemandNoteVo {

    private PayDemandNote payDemandNote;

    private List<CostDetails> costDetailsList;

}

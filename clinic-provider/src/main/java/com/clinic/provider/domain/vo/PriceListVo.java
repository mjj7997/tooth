package com.clinic.provider.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: majunjie
 * @Date: 2021年3月6日$ 16点04分$
 * @Description:
 */
@Data
public class PriceListVo {

    @ApiModelProperty("诊疗类")
    private List<GetPriceListVo> diagnosisVoList;

    @ApiModelProperty("药品类")
    private List<GetPriceListVo> medicineVoList;
}

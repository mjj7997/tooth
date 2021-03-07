package com.clinic.provider.domain.vo;

import com.clinic.provider.domain.entity.ClassDict;
import com.clinic.provider.domain.entity.PriceDict;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: majunjie
 * @Date: 2021年3月6日$ 15点55分$
 * @Description:
 */
@Data
public class GetPriceListVo {

    @ApiModelProperty("价格项目分类")
    private ClassDict classDict;

    @ApiModelProperty("价格项目明细")
    private List<PriceDict> priceDictList;
}

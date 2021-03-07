package com.clinic.provider.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: majunjie
 * @Date: 2021年3月2日$ 12点32分$
 * @Description:
 */
@Data
public class SaveClassDictDto implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("类别代码")
    private String classCode;

    @ApiModelProperty("类别名称")
    private String className;

    @ApiModelProperty("大类类别 1-诊疗类 2-西药类")
    private String priceType;

    @ApiModelProperty("医院代码")
    private String hospCode;
}

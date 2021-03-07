package com.clinic.provider.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: majunjie
 * @Date: 2021年3月2日$ 16点50分$
 * @Description:
 */
@Data
public class SavePriceDictDto {

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 项目code
     */
    @ApiModelProperty("项目code")
    private String itemCode;

    /**
     * 项目名称
     */
    @ApiModelProperty("项目名称")
    private String itemName;

    /**
     * 单价
     */
    @ApiModelProperty("单价")
    private Double price;

    /**
     * 单位
     */
    @ApiModelProperty("单位")
    private String unit;

    /**
     * 拼音码
     */
    @ApiModelProperty("拼音码")
    private String inputCode;

    /**
     * 项目类型划分
     */
    @ApiModelProperty("项目类型划分")
    private String classType;

    /**
     * 医院代码
     */
    @ApiModelProperty("医院代码")
    private String hospCode;

    /**
     * 项目类别名称
     */
    @ApiModelProperty("项目类别名称")
    private String className;
}

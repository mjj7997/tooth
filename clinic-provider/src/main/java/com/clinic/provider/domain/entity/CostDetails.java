package com.clinic.provider.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author majunjie
 * @since 2021-03-05
 */
public class CostDetails implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 患者病历号
     */
    @ApiModelProperty("患者病历号")
    private String patientId;

    /**
     * 入院次数
     */
    @ApiModelProperty("入院次数")
    private String visitId;

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
     * 总数
     */
    @ApiModelProperty("总数")
    private String amount;

    /**
     * 单价
     */
    @ApiModelProperty("单价")
    private Double price;

    /**
     * 折后价
     */
    @ApiModelProperty("折后价")
    private Double discountPrice;

    /**
     * 折扣率
     */
    @ApiModelProperty("折扣率")
    private String discountRate;

    /**
     * 收费单id
     */
    @ApiModelProperty("收费单id")
    private Integer payDemandId;

    /**
     * 医院代码
     */
    @ApiModelProperty("医院代码")
    private String hospCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getPayDemandId() {
        return payDemandId;
    }

    public void setPayDemandId(Integer payDemandId) {
        this.payDemandId = payDemandId;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }

    @Override
    public String toString() {
        return "CostDetails{" +
        "id=" + id +
        ", patientId=" + patientId +
        ", visitId=" + visitId +
        ", itemCode=" + itemCode +
        ", itemName=" + itemName +
        ", amount=" + amount +
        ", price=" + price +
        ", discountPrice=" + discountPrice +
        ", discountRate=" + discountRate +
        ", payDemandId=" + payDemandId +
        ", hospCode=" + hospCode +
        "}";
    }
}

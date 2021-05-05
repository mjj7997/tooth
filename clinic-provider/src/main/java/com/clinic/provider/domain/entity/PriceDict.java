package com.clinic.provider.domain.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author majunjie
 * @since 2021-03-02
 */
public class PriceDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目code
     */
    private String itemCode;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 单价
     */
    private Double price;

    /**
     * 单位
     */
    private String unit;

    /**
     * 拼音码
     */
    private String inputCode;

    /**
     * 项目类型划分
     */
    private String classType;

    /**
     * 医院代码
     */
    private String hospCode;

    /**
     * 项目类别名称
     */
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }

    @Override
    public String toString() {
        return "PriceDict{" +
                "id=" + id +
                ", itemCode=" + itemCode +
                ", itemName=" + itemName +
                ", price=" + price +
                ", unit=" + unit +
                ", inputCode=" + inputCode +
                ", classType=" + classType +
                ", hospCode=" + hospCode +
                ", className=" + className +
                "}";
    }
}

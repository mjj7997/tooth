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
public class PayDemandNote implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 性别 0-未知 1-男 2-女
     */
    @ApiModelProperty("性别 0-未知 1-男 2-女")
    private String sex;

    /**
     * 开单医生code
     */
    @ApiModelProperty("开单医生code")
    private String doctorCode;

    /**
     * 开单医生姓名
     */
    @ApiModelProperty("开单医生姓名")
    private String doctorName;

    /**
     * 助理code
     */
    @ApiModelProperty("助理code")
    private String assistantCode;

    /**
     * 助理姓名
     */
    @ApiModelProperty("助理姓名")
    private String assistantName;

    /**
     * 收费单日期
     */
    @ApiModelProperty("收费单日期")
    private String payNoteDate;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAssistantCode() {
        return assistantCode;
    }

    public void setAssistantCode(String assistantCode) {
        this.assistantCode = assistantCode;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getPayNoteDate() {
        return payNoteDate;
    }

    public void setPayNoteDate(String payNoteDate) {
        this.payNoteDate = payNoteDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }

    @Override
    public String toString() {
        return "PayDemandNote{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", visitId=" + visitId +
                ", name=" + name +
                ", sex=" + sex +
                ", doctorCode=" + doctorCode +
                ", doctorName=" + doctorName +
                ", assistantCode=" + assistantCode +
                ", assistantName=" + assistantName +
                ", payNoteDate=" + payNoteDate +
                ", remark=" + remark +
                ", hospCode=" + hospCode +
                "}";
    }
}

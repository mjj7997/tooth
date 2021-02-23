package com.clinic.provider.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: majunjie
 * @Date: 2021年2月23日$ 14点22分$
 * @Description:
 */
@Data
public class CaseHistoryDto {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @ApiModelProperty("工作人员主键")
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty("工作人员主键")
    private String name;

    /**
     * 性别 1-男 2-女 0-未知
     */
    @ApiModelProperty("工作人员主键")
    private Integer sex;

    /**
     * 年龄
     */
    @ApiModelProperty("工作人员主键")
    private String age;

    /**
     * 病历号
     */
    @ApiModelProperty("工作人员主键")
    private String patientId;

    /**
     * visit_id
     */
    @ApiModelProperty("工作人员主键")
    private String visitId;

    /**
     * 就诊类型 1-初诊 2-复诊
     */
    @ApiModelProperty("工作人员主键")
    private String clinicType;

    /**
     * 就诊医生
     */
    @ApiModelProperty("工作人员主键")
    private String registrationDoctor;

    /**
     * 就诊医生code
     */
    @ApiModelProperty("工作人员主键")
    private String registrationDoctorCode;

    /**
     * 助理
     */
    @ApiModelProperty("工作人员主键")
    private String assistant;

    /**
     * 就诊日期
     */
    @ApiModelProperty("工作人员主键")
    private String registrationDate;

    /**
     * 主诉
     */
    @ApiModelProperty("工作人员主键")
    private String symptom;

    /**
     * 现病史
     */
    @ApiModelProperty("工作人员主键")
    private String historyOfPresentIllness;

    /**
     * 既往史
     */
    @ApiModelProperty("工作人员主键")
    private String previousHistory;

    /**
     * 检查报告
     */
    @ApiModelProperty("工作人员主键")
    private String inspectionReport;

    /**
     * X光检查
     */
    @ApiModelProperty("工作人员主键")
    private String rayExamination;

    /**
     * 诊断
     */
    @ApiModelProperty("工作人员主键")
    private String diagnose;

    /**
     * 治疗
     */
    @ApiModelProperty("工作人员主键")
    private String treatment;

    /**
     * 医嘱
     */
    @ApiModelProperty("工作人员主键")
    private String doctorAdvice;

    /**
     * 医院code
     */
    @ApiModelProperty("工作人员主键")
    private String hospCode;

}

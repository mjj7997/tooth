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

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 性别 1-男 2-女 0-未知
     */
    @ApiModelProperty("性别 1-男 2-女 0-未知")
    private Integer sex;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private String age;

    /**
     * 病历号
     */
    @ApiModelProperty("病历号")
    private String patientId;

    /**
     * visit_id
     */
    @ApiModelProperty("visit_id")
    private String visitId;

    /**
     * 就诊类型 1-初诊 2-复诊
     */
    @ApiModelProperty("就诊类型 1-初诊 2-复诊")
    private String clinicType;

    /**
     * 就诊医生
     */
    @ApiModelProperty("就诊医生")
    private String registrationDoctor;

    /**
     * 就诊医生code
     */
    @ApiModelProperty("就诊医生code")
    private String registrationDoctorCode;

    /**
     * 助理
     */
    @ApiModelProperty("助理")
    private String assistant;

    /**
     * 就诊日期
     */
    @ApiModelProperty("就诊日期")
    private String registrationDate;

    /**
     * 主诉
     */
    @ApiModelProperty("主诉")
    private String symptom;

    /**
     * 现病史
     */
    @ApiModelProperty("现病史")
    private String historyOfPresentIllness;

    /**
     * 既往史
     */
    @ApiModelProperty("既往史")
    private String previousHistory;

    /**
     * 检查报告
     */
    @ApiModelProperty("检查报告")
    private String inspectionReport;

    /**
     * X光检查
     */
    @ApiModelProperty("X光检查")
    private String rayExamination;

    /**
     * 诊断
     */
    @ApiModelProperty("诊断")
    private String diagnose;

    /**
     * 治疗
     */
    @ApiModelProperty("治疗")
    private String treatment;

    /**
     * 医嘱
     */
    @ApiModelProperty("医嘱")
    private String doctorAdvice;

    /**
     * 医院code
     */
    @ApiModelProperty("医院code")
    private String hospCode;

    /**
     * 牙位信息
     */
    private String toothLocation;

    /**
     * 治疗计划
     */
    private String treatPlan;

}

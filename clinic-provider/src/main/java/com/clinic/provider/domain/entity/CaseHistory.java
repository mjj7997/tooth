package com.clinic.provider.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author majunjie
 * @since 2021-02-21
 */
public class CaseHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 1-男 2-女 0-未知
     */
    private Integer sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 病历号
     */
    private String patientId;

    /**
     * visit_id
     */
    private String visitId;

    /**
     * 就诊类型 1-初诊 2-复诊
     */
    private String clinicType;

    /**
     * 就诊医生
     */
    private String registrationDoctor;

    /**
     * 就诊医生code
     */
    private String registrationDoctorCode;

    /**
     * 助理
     */
    private String assistant;

    /**
     * 就诊日期
     */
    private String registrationDate;

    /**
     * 主诉
     */
    private String symptom;

    /**
     * 现病史
     */
    private String historyOfPresentIllness;

    /**
     * 既往史
     */
    private String previousHistory;

    /**
     * 检查报告
     */
    private String inspectionReport;

    /**
     * X光检查
     */
    private String rayExamination;

    /**
     * 诊断
     */
    private String diagnose;

    /**
     * 治疗
     */
    private String treatment;

    /**
     * 医嘱
     */
    private String doctorAdvice;

    /**
     * 医院code
     */
    private String hospCode;

    /**
     * 牙位信息
     */
    private String toothLocation;

    /**
     * 治疗计划
     */
    private String treatPlan;

    public String getTreatPlan() {
        return treatPlan;
    }

    public void setTreatPlan(String treatPlan) {
        this.treatPlan = treatPlan;
    }

    public String getToothLocation() {
        return toothLocation;
    }

    public void setToothLocation(String toothLocation) {
        this.toothLocation = toothLocation;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }

    public String getRegistrationDoctor() {
        return registrationDoctor;
    }

    public void setRegistrationDoctor(String registrationDoctor) {
        this.registrationDoctor = registrationDoctor;
    }

    public String getRegistrationDoctorCode() {
        return registrationDoctorCode;
    }

    public void setRegistrationDoctorCode(String registrationDoctorCode) {
        this.registrationDoctorCode = registrationDoctorCode;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getHistoryOfPresentIllness() {
        return historyOfPresentIllness;
    }

    public void setHistoryOfPresentIllness(String historyOfPresentIllness) {
        this.historyOfPresentIllness = historyOfPresentIllness;
    }

    public String getPreviousHistory() {
        return previousHistory;
    }

    public void setPreviousHistory(String previousHistory) {
        this.previousHistory = previousHistory;
    }

    public String getInspectionReport() {
        return inspectionReport;
    }

    public void setInspectionReport(String inspectionReport) {
        this.inspectionReport = inspectionReport;
    }

    public String getRayExamination() {
        return rayExamination;
    }

    public void setRayExamination(String rayExamination) {
        this.rayExamination = rayExamination;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
    }

    @Override
    public String toString() {
        return "CaseHistory{" +
                "id=" + id +
                ", name=" + name +
                ", sex=" + sex +
                ", age=" + age +
                ", patientId=" + patientId +
                ", visitId=" + visitId +
                ", clinicType=" + clinicType +
                ", registrationDoctor=" + registrationDoctor +
                ", registrationDoctorCode=" + registrationDoctorCode +
                ", assistant=" + assistant +
                ", registrationDate=" + registrationDate +
                ", symptom=" + symptom +
                ", historyOfPresentIllness=" + historyOfPresentIllness +
                ", previousHistory=" + previousHistory +
                ", inspectionReport=" + inspectionReport +
                ", rayExamination=" + rayExamination +
                ", diagnose=" + diagnose +
                ", treatment=" + treatment +
                ", doctorAdvice=" + doctorAdvice +
                ", hospCode=" + hospCode +
                ", toothLocation=" + toothLocation +
                ", treatPlan=" + treatPlan +
                "}";
    }
}

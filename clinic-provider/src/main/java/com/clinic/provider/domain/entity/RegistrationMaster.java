package com.clinic.provider.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
public class RegistrationMaster implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 病历号
     */
    private String patientId;

    /**
     * 就诊次数
     */
    private Integer visitId;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 1-候诊中  2-治疗中  3-已完成
     */
    private Integer clinicState;

    /**
     * 0-普通患者  1-vip患者
     */
    private Integer vipCode;

    /**
     * 挂号日期
     */
    private String registrationDate;

    /**
     * 操作日期
     */
    private String operationDate;

    /**
     * 挂号标签
     */
    private String clinicTag;

    /**
     * 实际就诊医生
     */
    private String registrationDoctor;

    /**
     * 医院代码
     */
    private String hospCode;

    /**
     * 实际就诊医生code
     */
    private String registrationDoctorCode;

    public String getRegistrationDoctorCode() {
        return registrationDoctorCode;
    }

    public void setRegistrationDoctorCode(String registrationDoctorCode) {
        this.registrationDoctorCode = registrationDoctorCode;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }

    public String getRegistrationDoctor() {
        return registrationDoctor;
    }

    public void setRegistrationDoctor(String registrationDoctor) {
        this.registrationDoctor = registrationDoctor;
    }

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

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getClinicState() {
        return clinicState;
    }

    public void setClinicState(Integer clinicState) {
        this.clinicState = clinicState;
    }

    public Integer getVipCode() {
        return vipCode;
    }

    public void setVipCode(Integer vipCode) {
        this.vipCode = vipCode;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String clinicDate) {
        this.registrationDate = clinicDate;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public String getClinicTag() {
        return clinicTag;
    }

    public void setClinicTag(String clinicTag) {
        this.clinicTag = clinicTag;
    }

    @Override
    public String toString() {
        return "RegistrationMaster{" +
        "id=" + id +
        ", patientId=" + patientId +
        ", visitId=" + visitId +
        ", name=" + name +
        ", phone=" + phone +
        ", clinicState=" + clinicState +
        ", vipCode=" + vipCode +
        ", clinicDate=" + registrationDate +
        ", operationDate=" + operationDate +
        ", clinicTag=" + clinicTag +
                ", registrationDoctor=" + registrationDoctor +
                ", hospCode=" + hospCode +
                ", registrationDoctorCode=" + registrationDoctorCode +
        "}";
    }
}

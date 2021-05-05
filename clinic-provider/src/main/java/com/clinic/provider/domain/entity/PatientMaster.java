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
public class PatientMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 患者号
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 性别 0-未知 1-男 2-女
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 出生日期
     */
    private String birth;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 座机区号
     */
    private String areaCode;

    /**
     * 座机
     */
    private String tel;

    /**
     * 就诊类型 1-初诊 2-复诊
     */
    private Integer clinicType;

    /**
     * 就诊医生
     */
    private String clinicDoctor;

    /**
     * 就诊日期
     */
    private String clinicDate;

    /**
     * 就诊事项
     */
    private String clinicTagId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 身份证号
     */
    private String identity;

    /**
     * 地址-省
     */
    private String addrProvince;

    /**
     * 地址-市
     */
    private String addrCity;

    /**
     * 地址-区县
     */
    private String addrCounty;

    /**
     * 地址-详情
     */
    private String addrDetailed;

    /**
     * 0-普通患者  1-vip患者
     */
    private Integer vipCode;

    /**
     * 最后更新时间
     */
    private String lastDate;

    /**
     * 医院代码
     */
    private String hospCode;

    /**
     * 就诊医生代码
     */
    private String clinicDoctorCode;

    public String getClinicDoctorCode() {
        return clinicDoctorCode;
    }

    public void setClinicDoctorCode(String clinicDoctorCode) {
        this.clinicDoctorCode = clinicDoctorCode;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public Integer getVipCode() {
        return vipCode;
    }

    public void setVipCode(Integer vipCode) {
        this.vipCode = vipCode;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getClinicType() {
        return clinicType;
    }

    public void setClinicType(Integer clinicType) {
        this.clinicType = clinicType;
    }

    public String getClinicDoctor() {
        return clinicDoctor;
    }

    public void setClinicDoctor(String clinicDoctor) {
        this.clinicDoctor = clinicDoctor;
    }

    public String getClinicDate() {
        return clinicDate;
    }

    public void setClinicDate(String clinicDate) {
        this.clinicDate = clinicDate;
    }

    public String getClinicTagId() {
        return clinicTagId;
    }

    public void setClinicTagId(String clinicTagId) {
        this.clinicTagId = clinicTagId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(String addrProvince) {
        this.addrProvince = addrProvince;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrCounty() {
        return addrCounty;
    }

    public void setAddrCounty(String addrCounty) {
        this.addrCounty = addrCounty;
    }

    public String getAddrDetailed() {
        return addrDetailed;
    }

    public void setAddrDetailed(String addrDetailed) {
        this.addrDetailed = addrDetailed;
    }

    @Override
    public String toString() {
        return "PatientMaster{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", name=" + name +
                ", sex=" + sex +
                ", age=" + age +
                ", birth=" + birth +
                ", phone=" + phone +
                ", areaCode=" + areaCode +
                ", tel=" + tel +
                ", clinicType=" + clinicType +
                ", clinicDoctor=" + clinicDoctor +
                ", clinicDate=" + clinicDate +
                ", clinicTagId=" + clinicTagId +
                ", remark=" + remark +
                ", identity=" + identity +
                ", addr province=" + addrProvince +
                ", addrCity=" + addrCity +
                ", addrCounty=" + addrCounty +
                ", addrDetailed=" + addrDetailed +
                ", vipCode=" + vipCode +
                ", lastDate=" + lastDate +
                ", hospCode=" + hospCode +
                ", clinicDoctorCode=" + clinicDoctorCode +
                "}";
    }
}

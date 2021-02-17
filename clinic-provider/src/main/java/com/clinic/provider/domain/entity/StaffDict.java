package com.clinic.provider.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author majunjie
 * @since 2021-01-22
 */
//@TableName("staff_dict")
public class StaffDict implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 工作人员主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("工作人员主键")
    private Integer id;

    /**
     * 工号
     */
    @ApiModelProperty("工号")
    private String userId;

    /**
     * 状态，启用-0，停用-1，默认0
     */
    @ApiModelProperty("状态，启用-0，停用-1，默认0")
    private Integer status;

    /**
     * 员工名
     */
    @ApiModelProperty("员工名")
    private String userName;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String tel;

    /**
     * 职位
     */
    @ApiModelProperty("职位")
    private String job;

    /**
     * 权限点
     */
    @ApiModelProperty("权限点")
    private Integer jobPoint;

    /**
     * 医院名
     */
    @ApiModelProperty("医院名")
    private String hospName;

    /**
     * 医院代码
     */
    @ApiModelProperty("医院代码")
    private String hospCode;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createName;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private String updateName;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 签名
     */
    @ApiModelProperty("签名")
    private String signature;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private String createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private String updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getJobPoint() {
        return jobPoint;
    }

    public void setJobPoint(Integer jobPoint) {
        this.jobPoint = jobPoint;
    }

    public String getHospName() {
        return hospName;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "StaffDict{" +
        "id=" + id +
        ", userId=" + userId +
        ", status=" + status +
        ", userName=" + userName +
        ", tel=" + tel +
        ", job=" + job +
        ", jobPoint=" + jobPoint +
        ", hospName=" + hospName +
        ", hospCode=" + hospCode +
        ", createName=" + createName +
        ", updateName=" + updateName +
        ", password=" + password +
        ", signature=" + signature +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}

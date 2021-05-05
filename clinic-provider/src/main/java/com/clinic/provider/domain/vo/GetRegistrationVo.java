package com.clinic.provider.domain.vo;

import com.clinic.provider.domain.entity.TagDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: majunjie
 * @Date: 2021年2月15日$ 19点20分$
 * @Description:
 */
@Data
public class GetRegistrationVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 患者号
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
     * 1-候诊中  2-治疗中  3-已完成
     */
    private Integer clinicState;

    /**
     * 挂号日期
     */
    private String registrationDate;

    /**
     * 操作日期
     */
    private String operationDate;

    /**
     * 就诊日期
     */
    private String clinicTag;

    /**
     * 标签列表
     */
    private List<TagDict> tagDictList;

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

    /**
     * 就诊医生代码
     */
    private String clinicDoctorCode;


}

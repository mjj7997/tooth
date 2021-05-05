package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.GetPantientDto;
import com.clinic.provider.domain.dto.PatientMasterDto;
import com.clinic.provider.domain.entity.PatientMaster;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
public interface PatientMasterService extends IService<PatientMaster> {

    /**
     * 获取生成得病历号
     *
     * @return
     */
    JSONObject getpatientId();

    /**
     * 保存患者信息
     *
     * @return
     */
    JSONObject savePatientMaster(PatientMasterDto patientMasterDto);

    /**
     * 查询
     *
     * @return
     */
    JSONObject getPatientMasterByDto(GetPantientDto getPantientDto);

}

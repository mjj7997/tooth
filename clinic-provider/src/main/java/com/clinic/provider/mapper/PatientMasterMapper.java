package com.clinic.provider.mapper;

import com.clinic.provider.domain.entity.PatientMaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
public interface PatientMasterMapper extends BaseMapper<PatientMaster> {

    List<PatientMaster> getPatientMasterByDto(Map<String, Object> map);

}

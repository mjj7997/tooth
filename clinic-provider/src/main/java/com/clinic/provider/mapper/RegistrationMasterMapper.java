package com.clinic.provider.mapper;

import com.clinic.provider.domain.entity.RegistrationMaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clinic.provider.domain.vo.GetRegistrationVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
public interface RegistrationMasterMapper extends BaseMapper<RegistrationMaster> {

    List<GetRegistrationVo> getRegistrationMaster();

}

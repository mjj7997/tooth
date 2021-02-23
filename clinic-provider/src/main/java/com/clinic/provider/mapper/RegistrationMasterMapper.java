package com.clinic.provider.mapper;

import com.clinic.provider.domain.entity.RegistrationMaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clinic.provider.domain.vo.GetRegistrationVo;
import org.apache.ibatis.annotations.Param;

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

    List<GetRegistrationVo> getRegistrationMaster(@Param("hospCode") String hospCode);

    List<GetRegistrationVo> getRegistrationById(@Param("hospCode") String hospCode,@Param("patientId")String patientId,
                                                @Param("visitId")String visitId);

    Integer updateRegistrationStatus(@Param("hospCode") String hospCode,@Param("patientId")String patientId,
                                                     @Param("visitId")String visitId,@Param("clinicState")Integer clinicState);


}

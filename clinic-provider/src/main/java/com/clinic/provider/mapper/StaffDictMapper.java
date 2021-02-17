package com.clinic.provider.mapper;

import com.clinic.provider.domain.dto.SelectStaffDto;
import com.clinic.provider.domain.entity.StaffDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author majunjie
 * @since 2021-01-22
 */
public interface StaffDictMapper extends BaseMapper<StaffDict> {


    List<StaffDict> getStaffDict(@Param("status") Integer status,@Param("hospCode")String hospCode,
                                 @Param("input")String input);

}

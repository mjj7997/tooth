package com.clinic.provider.mapper;

import com.clinic.provider.domain.entity.PriceDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author majunjie
 * @since 2021-03-02
 */
public interface PriceDictMapper extends BaseMapper<PriceDict> {

    List<PriceDict> getPriceDictByClassId(@Param("classId") String classId, @Param("input") String input, @Param("hospCode") String hospCode);

}

package com.clinic.provider.mapper;

import com.clinic.provider.domain.entity.TitalDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author majunjie
 * @since 2021-02-12
 */
public interface TitalDictMapper extends BaseMapper<TitalDict> {

    List<TitalDict> getTitalDict(@Param("tagList")List<Integer> tagList);


}

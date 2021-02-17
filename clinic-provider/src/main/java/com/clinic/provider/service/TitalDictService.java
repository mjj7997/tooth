package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.TitalDictDto;
import com.clinic.provider.domain.entity.TitalDict;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-12
 */
public interface TitalDictService extends IService<TitalDict> {

    JSONObject saveTitalDict(TitalDictDto titalDictDto);

    JSONObject deleteTitalDict(Integer id);

    JSONObject updateTitalDict(TitalDictDto titalDictDto);

}

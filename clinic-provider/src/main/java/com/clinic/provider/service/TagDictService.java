package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.TagListDto;
import com.clinic.provider.domain.entity.TagDict;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
public interface TagDictService extends IService<TagDict> {

    JSONObject getPatientTag();

    JSONObject getRegistrationTag(TagListDto tagListDto);

}

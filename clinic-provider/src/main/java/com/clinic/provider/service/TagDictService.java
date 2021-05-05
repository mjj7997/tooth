package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.TagListDto;
import com.clinic.provider.domain.entity.TagDict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
public interface TagDictService extends IService<TagDict> {

    JSONObject getPatientTag(String hospCode);

    JSONObject getRegistrationTag(TagListDto tagListDto);

}

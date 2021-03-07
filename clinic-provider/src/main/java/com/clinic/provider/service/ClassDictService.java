package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.SaveClassDictDto;
import com.clinic.provider.domain.entity.ClassDict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-03-02
 */
public interface ClassDictService extends IService<ClassDict> {

    JSONObject getClassDict(String hospCode);

    JSONObject saveOrUpdateClassDict(SaveClassDictDto saveClassDictDto);

    JSONObject deleteClassDictById(Integer id);

    JSONObject getMenuList(String hospCode);

}

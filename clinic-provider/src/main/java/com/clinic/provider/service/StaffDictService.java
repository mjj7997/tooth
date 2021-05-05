package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.SelectStaffDto;
import com.clinic.provider.domain.dto.StaffDictDto;
import com.clinic.provider.domain.entity.StaffDict;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-01-22
 */
public interface StaffDictService extends IService<StaffDict> {

    JSONObject saveStaffDict(StaffDictDto staffDictDto);

    JSONObject getStaffDict(SelectStaffDto selectStaffDto);

    JSONObject delStaffDictById(Integer id);

    JSONObject updateStaffDictById(StaffDictDto staffDictDto);

    JSONObject getStaffDictByUser(String userId);


}

package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.GetRegistrationByIdDto;
import com.clinic.provider.domain.dto.SaveRegistrationDto;
import com.clinic.provider.domain.dto.UpdateRegistrationStatusDto;
import com.clinic.provider.domain.entity.RegistrationMaster;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
public interface RegistrationMasterService extends IService<RegistrationMaster> {


    JSONObject saveRegistrationMaster(SaveRegistrationDto saveRegistrationDto);

    JSONObject getRegistrationMaster(String hospCode);

    JSONObject getHeadline(String hospCode);

    JSONObject getRegistrationById(GetRegistrationByIdDto getRegistrationByIdDto);

    JSONObject updateRegistrationStatus(UpdateRegistrationStatusDto updateRegistrationStatusDto);


}
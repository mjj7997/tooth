package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.entity.CostDetails;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-03-05
 */
public interface CostDetailsService extends IService<CostDetails> {

    JSONObject getCostDetails(String patientId, String visitId, String hospCode);

    JSONObject getCostDetailsList(String patientId, String hospCode);

}

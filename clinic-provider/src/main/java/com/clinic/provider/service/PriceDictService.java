package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.SavePriceDictDto;
import com.clinic.provider.domain.entity.PriceDict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-03-02
 */
public interface PriceDictService extends IService<PriceDict> {

    JSONObject getPriceDictByClassId(String classId,String input,String hospCode);

    JSONObject saveOrUpdatePriceDict(SavePriceDictDto savePriceDictDto);

    JSONObject deletePriceDictById(String id);

}

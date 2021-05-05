package com.clinic.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.clinic.provider.domain.dto.PayDemandNoteDto;
import com.clinic.provider.domain.entity.PayDemandNote;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author majunjie
 * @since 2021-03-05
 */
public interface PayDemandNoteService extends IService<PayDemandNote> {

    JSONObject saveOrUpdatePayDemandNote(PayDemandNoteDto payDemandNoteDto);

    JSONObject deletePayDemandNote(String id);

    JSONObject getPayDemandNote(String patientId, String visitId, String hospCode);

}

package com.clinic.provider.domain.dto;

import com.clinic.provider.domain.entity.PatientMaster;
import com.clinic.provider.domain.entity.TagDict;
import lombok.Data;

import java.util.List;

/**
 * @author: majunjie
 * @Date: 2021年2月11日$ 14点56分$
 * @Description:
 */
@Data
public class PatientMasterDto {

    private PatientMaster patientMaster;

    private List<TagDict> tagDictList;


}

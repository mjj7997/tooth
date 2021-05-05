package com.clinic.provider.domain.dto;

import com.clinic.provider.domain.entity.StaffDict;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: majunjie
 * @Date: $ $
 * @Description:
 */
@Data
public class StaffDictDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<StaffDict> staffDictList;
}

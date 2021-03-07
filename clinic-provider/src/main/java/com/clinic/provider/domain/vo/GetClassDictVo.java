package com.clinic.provider.domain.vo;

import com.clinic.provider.domain.entity.ClassDict;
import lombok.Data;

import java.util.List;

/**
 * @author: majunjie
 * @Date: 2021年3月2日$ 11点33分$
 * @Description:
 */
@Data
public class GetClassDictVo {

    private List<ClassDict> diagnosis;

    private List<ClassDict> medicines;
}

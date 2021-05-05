package com.clinic.provider.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: majunjie
 * @Date: 2021年2月12日$ 14点44分$
 * @Description:
 */
@Data
public class TitalDictDto {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 标签code
     */
    private String titalCode;

    /**
     * 标签名字
     */
    private String titalName;

    /**
     * 父类标签名
     */
    private String tagCode;

    /**
     * 持续时间
     */
    private String time;

    /**
     * 标签名字
     */
    private String tagName;

    /**
     * 医院代码
     */
    private String hospCode;


}

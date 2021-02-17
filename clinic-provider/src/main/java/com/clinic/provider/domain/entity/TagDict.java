package com.clinic.provider.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author majunjie
 * @since 2021-02-11
 */
public class TagDict implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签code
     */
    private String tagCode;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 1-代表新增患者 2-表示挂号标签
     */
    private Integer tagType;

    /**
     * 医院代码
     */
    private String hospCode;

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagType() {
        return tagType;
    }

    public void setTagType(Integer tagType) {
        this.tagType = tagType;
    }

    @Override
    public String toString() {
        return "TagDict{" +
        "id=" + id +
        ", tagCode=" + tagCode +
        ", tagName=" + tagName +
        ", tagType=" + tagType +
                ", hospCode=" + hospCode +
        "}";
    }
}

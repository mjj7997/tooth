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
 * @since 2021-02-12
 */
public class TitalDict implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 标签名
     */
    private String tagName;

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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitalCode() {
        return titalCode;
    }

    public void setTitalCode(String titalCode) {
        this.titalCode = titalCode;
    }

    public String getTitalName() {
        return titalName;
    }

    public void setTitalName(String titalName) {
        this.titalName = titalName;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TitalDict{" +
        "id=" + id +
        ", titalCode=" + titalCode +
        ", titalName=" + titalName +
        ", tagCode=" + tagCode +
        ", time=" + time +
                ", tagName=" + tagName +
                ", hospCode=" + hospCode +
        "}";
    }
}

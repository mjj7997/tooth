package com.clinic.common.utils;

/**
 * @author: majunjie
 * @Date: 2021年2月23日$ 11点31分$
 * @Description:
 */
public class PathUtils {

    //获取文件后缀名
    public static String getFlieSuffixName (String flieName){
        String suffixName = flieName.substring(flieName.indexOf("."));
        return suffixName;
    }
}

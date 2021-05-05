package com.clinic.common.utils;

import java.text.NumberFormat;

/**
 * @author: majunjie
 * @Date: 2021年2月11日$ 14点06分$
 * @Description:
 */
public class NumberUtil {
    /**
     * 数字前面自动补零
     *
     * @param number 数字
     * @return
     */
    public static String geFourNumber(int length, int number) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(length);
        formatter.setGroupingUsed(false);
        return formatter.format(number);
    }
}

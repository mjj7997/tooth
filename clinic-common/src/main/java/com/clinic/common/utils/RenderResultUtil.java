package com.clinic.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @parm :
 * @desc :
 * @auther :
 * @createTime :
 */
public class RenderResultUtil {

    /**
     * @parm :
     * @desc :返回消息成功
     * @auther : majunjie
     * @createTime :
     */
    public static <T> JSONObject renderSuccess(String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setStatus("200");
        jsonResult.setMsg(msg);
        return toJSONObject(jsonResult);
    }

    /**
     * @parm :
     * @desc :返回消息成功
     * @auther : majunjie
     * @createTime :
     */
    public static <T> JSONObject success(String msg, T t) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setStatus("200");
        jsonResult.setMsg(msg);
        jsonResult.setResult(t);
        return toJSONObject(jsonResult);
    }

    /**
     * @parm :
     * @desc :返回消息失败
     * @auther :majunjie
     * @createTime :
     */
    public static JSONObject renderError(String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setStatus("500");
        jsonResult.setMsg(msg);
        return toJSONObject(jsonResult);
    }

    /**
     * @parm :
     * @desc :返回消息失败
     * @auther :majunjie
     * @createTime :
     */
    public static <T> JSONObject error(String msg, T t) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setStatus("500");
        jsonResult.setMsg(msg);
        jsonResult.setResult(t);
        return toJSONObject(jsonResult);
    }

    private static JSONObject toJSONObject(JsonResult result) {
        try {
            if (result == null) {
                return null;
            }
            // 对象转换  SerializerFeature.WriteNullStringAsEmpty)
            return JSON.parseObject(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject json = new JSONObject();
            json.put("msg", "error");
            return json;
        }
    }
}

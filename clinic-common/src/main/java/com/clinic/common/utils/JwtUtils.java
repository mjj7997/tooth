package com.clinic.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author: majunjie
 * @Date: 2021年1月26日$ 19点18分$
 * @Description:
 */
public class JwtUtils {

    //SING签名的设置，不能对外暴露
    public static final String SING = "token!J1JK3JH^&g%f*f@f*(f!)fs*#s*$H3J4DK43";

    /**
     * @Description 生成token header.payload.sing
     * @Author MSFH
     * @Date 2020-8-27 10:48:52
     * @Param Map 集合存入payload信息
     * @Return token
     * @Exception
     */
    public static String getToken(Map<String, String> map) {
        //设置令牌的过期时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);

        //创建JWT builder
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(instance.getTime()) //指定令牌过期时间
                .sign(Algorithm.HMAC256(SING));
        return token;
    }


    /**
     * @Description 验证令牌是否合法
     * @Author MSFH
     * @Date 2020-8-27 10:57:04
     */
    public static void verify(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

    /**
     * @Author MSFH
     * @Date 2020-8-27 11:13:52
     * @Return DecodedJWT JWT信息获取
     * @Description 获取JWT的信息
     */
    public static DecodedJWT getTokenInfo(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        return verify;
    }
}

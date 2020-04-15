package com.soft1851.spring.boot.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/15 17:50
 * @Version 1.0
 **/
@Slf4j
public class JwtTokenUtil {
    private static String user;
    /**
     * 加密
     *
     * @param userId
     * @param userRole
     * @param expiresAt
     * @return
     */
    public static String getToken(final String userId, final String userRole, Date expiresAt) {
        String token = null;
        user = userId;
//        try {
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userId", userId)
                    .withClaim("userRole", userRole)
                    .withExpiresAt(expiresAt)
                    //使用HMAC256加密算法
                    .sign(Algorithm.HMAC256(MD5Util.md5Hex(userId)));
//                    .sign(Algorithm.HMAC256(MD5Util.md5Hex(userId)));
//        } catch (UnsupportedEncodingException e) {
//            log.error("不支持的编码格式");
//        }
        return token;
    }

    /**
     * 解密
     * @param token
     * @return
     */
    public static DecodedJWT deToken(final String token) {
        DecodedJWT jwt;
        JWTVerifier verifier=null;
//        try {
            verifier = JWT.require(Algorithm.HMAC256(MD5Util.md5Hex(user)))
                    .withIssuer("auth0")
                    .build();
//        }catch (UnsupportedEncodingException e){
//            log.error("不支持的编码格式");
//        }
        assert verifier !=null;
        jwt = verifier.verify(token);
        return jwt;
    }

    /**
     * 获取userId
     * @param token
     * @return String
     */
    public static String getUserId(String token) {
        return deToken(token).getClaim("userId").asString();
    }

    /**
     * 获取role
     * @param token
     * @return
     */
    public static String getUserRole(String token) {
        System.out.println("************************************");
        System.out.println( deToken(token).getClaim("userRole").asString());
        System.out.println("************************************");
        return deToken(token).getClaim("userRole").asString();
    }

    /**
     * 验证是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token){
        return deToken(token).getExpiresAt().before(new Date());
    }

    public static void main(String[] args) {
        System.out.println(isExpiration("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsInVzZXJSb2xlIjoiYWRtaW4iLCJleHAiOjE1ODY5NTMzODYsInVzZXJJZCI6IjJlNDc2MDgzLTlkMzMtNDVjMC04NTEzLWQxODQzMjNjMDYyYSJ9.YyT5zWbvR-m3AGbWCw6JAuXqqJAzhwiZop7fa9M2ce8"));
    }
}


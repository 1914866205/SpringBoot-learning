package com.soft1851.spring.boot.jwt.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.soft1851.spring.boot.jwt.util.MD5Util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/15 10:48
 * @Version 1.0
 **/
public class Decrypt {

    public DecodedJWT deToken(final String token,final String username) {
        DecodedJWT jwt = null;
            //使用HMAC256加密算法，mySecret是用来加密数字签名的密钥
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(MD5Util.md5Hex(username)))
                    .withIssuer("auth0")
                    .build();//Reusable verifier instance
        try {
            jwt = verifier.verify(token);
//        System.out.println(new Date(System.currentTimeMillis()).getTime());
//        System.out.println(jwt.getExpiresAt().getTime());

        } catch (JWTVerificationException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return jwt;
    }
}

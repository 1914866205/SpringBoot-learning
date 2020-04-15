package com.soft1851.spring.boot.jwt.test;

import com.auth0.jwt.interfaces.DecodedJWT;
import java.lang.Thread;

import java.util.Date;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/15 10:53
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //生成token
        Encrypt encrypt = new Encrypt();
        String token = encrypt.getToken(false, "1914866205", "ntt", "man");
//        System.out.println(token);
        //解密token
        Decrypt decrypt = new Decrypt();
//        System.out.println("decrypt.deToken(token):"+decrypt.deToken(token));
        DecodedJWT jwt = decrypt.deToken(token,"1914866205");
            System.out.println("issuer: " + jwt.getIssuer());
            System.out.println("isVip:  " + jwt.getClaim("isVip").asBoolean());
            System.out.println("username: " + jwt.getClaim("username").asString());
            System.out.println("name:     " + jwt.getClaim("name").asString());
            System.out.println("sex:     " + jwt.getClaim("sex").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
        long time = (long) jwt.getExpiresAt().getTime() - (long) new Date(System.currentTimeMillis()).getTime();
        while (time>0){
            System.out.println("token剩余时间还有"+time/1000+"秒");
            time = (long) jwt.getExpiresAt().getTime() - (long) new Date(System.currentTimeMillis()).getTime();
            Thread.sleep(1000);
        }
        System.out.println("token已过期");

    }
}

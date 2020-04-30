package com.soft1851.springboot.test.timer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/20 11:58
 * @Version 1.0
 **/
public class SignIn implements Runnable{
    private long signIn=new Date().getTime();
    private boolean flag = false;
    private long during=0;
    public void setSignIn(long endSignIn){
        this.during = endSignIn;
        this.signIn += endSignIn;
    }
    public void signInControl(){
        if (!flag){
            //如果是第一次启动，就开启活动
            //记录当前时间
            flag = true;
            System.out.println("开始签到，结束时间为" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(signIn));
        }else {
            //如果不是第一次启动，就关闭活动‘
            flag = false;
            System.out.println("签到结束");
            System.exit(0);
        }
    }
    public void startSignIn(){
        new Timer("start").schedule(new TimerTask() {
            @Override
            public void run() {
                signInControl();
            }
        },1000,during);
        // 一秒后执行 ，  周期为during
    }

    @Override
    public void run() {
        while (!flag){
            startSignIn();
        }
    }
}


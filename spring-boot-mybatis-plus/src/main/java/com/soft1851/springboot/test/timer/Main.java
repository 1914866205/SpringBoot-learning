package com.soft1851.springboot.test.timer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/19 23:05
 * @Version 1.0
 **/


/**
 * flag=false
 * 开始签到活动   开启，指定时间后关闭
 *      更改flag=true
 * 开始签到       连续调用
 *      if(flag)签到
 * 结束签到活动   定时结束
 *      flag=false
 */
public class Main {
    public static void main(String[] args) {
        //开始签到
        SignIn signIn = new SignIn();
        //设置结束时间
        signIn.setSignIn(3*60 * 1000);
        //开始签到
        Thread thread = new Thread(signIn);
        thread.start();
    }
}

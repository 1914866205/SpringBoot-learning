package com.soft1851.springboot.test.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/19 22:57
 * @Version 1.0
 **/
public class QuarFirstJob {
    public void first(){
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String strTime = new SimpleDateFormat("HH-mm-ss").format(new Date());
        System.out.println(strTime+":Hello World!");
    }
}

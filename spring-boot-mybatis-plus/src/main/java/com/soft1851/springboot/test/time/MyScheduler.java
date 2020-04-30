package com.soft1851.springboot.test.time;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/19 21:51
 * @Version 1.0
 **/
public class MyScheduler {
    public static void main(String[] args) throws SchedulerException {
        //创建调度器Schedule
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //创建JobDetail实例，并与HelloWorldJob类绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class).withIdentity("job1", "job1group").build();
        //创建触发器Trigger实例(立即执行，每隔1s执行一次)
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();
//        Trigger cronTrigger=TriggerBuilder.newTrigger()
//                .withIdentity("trigger2","triggerGroup2")
//                .startNow()
//                .withSchedule(cronSchedule)

        //开始执行
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}

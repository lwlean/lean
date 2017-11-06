package com.lean.controller;

import com.lean.quartz.TestJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.quartz.JobBuilder.newJob;

@RequestMapping(value = "/quartz")
@RestController
public class QuartzController {

    final Logger logger = LoggerFactory.getLogger(QuartzController.class);

    @Autowired
    private Scheduler scheduler;

    @GetMapping("/start")
    public void start() {
        try {
            logger.info("into quartz method！");

            scheduler.start();

            JobDetail jobDetail = newJob(TestJob.class).withIdentity("TestJob", "group1").usingJobData("name", "llw2").build();
//            Trigger trigger = newTrigger().withIdentity("trigger", "group1").startAt(runTime).build();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("* * * * * ?");

            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("TestJob", "group1").withSchedule(cronScheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/stop")
    public void stop() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            logger.error("catch exception:", e);
            e.printStackTrace();
        }
    }

    @GetMapping("/pause")
    public void pause() {
        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.pauseJob(JobKey.jobKey("TestJob", "group1"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/resume")
    public void resume() {
        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.resumeJob(JobKey.jobKey("TestJob", "group1"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }


}

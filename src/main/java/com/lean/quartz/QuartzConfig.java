package com.lean.quartz;

import com.lean.domain.JobDetailBean;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

import static org.quartz.JobBuilder.newJob;

@Component
public class QuartzConfig {

    @Value("${test.quartz}")
    private String cronExpression;

    @Bean(name = "jobDetailBean")
    public JobDetailBean getBean() {
       JobDetailBean jobDetailBean = new JobDetailBean();
       jobDetailBean.setJobClass("com.lean.quartz.TestJob");
       return jobDetailBean;
    }

    @Bean
    public Scheduler startScheduler(JobDetailBean jobDetailBean) throws SchedulerException {

        final StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();

        Properties properties = new Properties();
        properties.get("./quartz/quartz.properties");

        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        final String jobClass = jobDetailBean.getJobClass();

        scheduler.start();

        Job job = getJobClass(jobClass);

        if (job == null) return scheduler;

        JobDetail jobDetail = newJob(job.getClass()).withIdentity(jobClass, jobClass).build();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClass, jobClass).withSchedule(cronScheduleBuilder).build();

        scheduler.scheduleJob(jobDetail, trigger);

        return scheduler;

    }

    private Job getJobClass(String jobClass) {
        try {
            Class<?> clazz = Class.forName(jobClass);
            Object o = clazz.newInstance();
            if (Job.class.isInstance(o)) {
                return (Job) o;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}

package com.lean.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJob implements Job{

    final Logger logger = LoggerFactory.getLogger(TestJob.class);

    public void doJob() {
        logger.info("into job");
    }

    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {
        logger.info("i am into this method!");
    }
}

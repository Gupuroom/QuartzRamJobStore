package com.springboot;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CronJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String Dev = jobDataMap.getString("Dev");
		String Company = jobDataMap.getString("Company");
		JobKey jobKey = context.getJobDetail().getKey();

		log.info("============================================================================");
		log.info("Develope by {} from {}", Dev, Company);
		log.info("CronJob started :: jobKey : {}", jobKey);
	}
}
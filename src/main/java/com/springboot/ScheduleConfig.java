package com.springboot;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfig
{
	@Bean
	public JobDetail scheduleJobDetail()
	{
		JobDataMap jobMap = new JobDataMap();
		jobMap.put("Dev", "이동재");
		jobMap.put("Company", "플랜티넷");
		return JobBuilder
				.newJob(CronJob.class).withIdentity("scheduleJob").usingJobData(jobMap).storeDurably()
				.build();
		
//		return JobBuilder
//				.newJob(CronJob.class).withIdentity("scheduleJob").usingJobData("name","이동재").storeDurably()
//				.build();
	}
	
	@Bean
	public Trigger scheduleJobTrigger()
	{
		//cron
		CronScheduleBuilder cronBuilder = CronScheduleBuilder.cronSchedule("0/20 * * * * ?");
		
		return TriggerBuilder
				.newTrigger().forJob(scheduleJobDetail()).withIdentity("scheduleTrigger").withSchedule(cronBuilder)
				.build();
	}
}

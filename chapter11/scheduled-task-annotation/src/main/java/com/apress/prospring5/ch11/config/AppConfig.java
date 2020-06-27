package com.apress.prospring5.ch11.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by iuliana.cosmina on 6/5/17.
 */
@Configuration
@Import({DataServiceConfig.class})
@EnableScheduling
public class AppConfig {

    // decomment this to use the TaskScheduler explicitly declared bean
	/*
	@Bean TaskScheduler carScheduler() {
		ThreadPoolTaskScheduler carScheduler = new ThreadPoolTaskScheduler();
		carScheduler.setPoolSize(10);
		return carScheduler;
	}
	*/
}

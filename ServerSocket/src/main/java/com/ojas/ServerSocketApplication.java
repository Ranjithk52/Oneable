package com.ojas;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ServerSocketApplication {
	
	@Scheduled(cron = "55 32 4 7 4 5")
	public static void scheduledJob() {
		LocalDateTime current=LocalDateTime.now();
		System.out.println(current);
		System.out.println("From Schedulerrrr....!");
		
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerSocketApplication.class, args);
		
		scheduledJob();
	}

}

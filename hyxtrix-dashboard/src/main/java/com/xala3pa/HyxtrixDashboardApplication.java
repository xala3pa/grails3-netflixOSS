package com.xala3pa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HyxtrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyxtrixDashboardApplication.class, args);
	}
}

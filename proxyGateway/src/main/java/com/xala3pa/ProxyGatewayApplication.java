package com.xala3pa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ProxyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyGatewayApplication.class, args);
	}
}

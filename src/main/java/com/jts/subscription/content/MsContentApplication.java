package com.jts.subscription.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsContentApplication.class, args);
	}

}

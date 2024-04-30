package com.ehrc.NIMHANSWhatsAppBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NimhansWhatsAppBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimhansWhatsAppBotApplication.class, args);
	}

}
package com.kevo.eCommerceOauthII;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ECommerceOauthIiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceOauthIiApplication.class, args);
	}

}

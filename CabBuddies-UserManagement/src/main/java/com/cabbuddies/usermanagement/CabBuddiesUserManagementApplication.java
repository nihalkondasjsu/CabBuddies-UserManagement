package com.cabbuddies.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.cabbuddieslib","com.cabbuddies.usermanagement"})
@ComponentScan({"com.cabbuddieslib","com.cabbuddies.usermanagement"})
@EnableJpaRepositories({"com.cabbuddieslib","com.cabbuddies.usermanagement"})
public class CabBuddiesUserManagementApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CabBuddiesUserManagementApplication.class, args);
		System.out.println(CabBuddiesUserManagementApplication.class.getName()+"Server Started");
		for(String beanName:context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}
}

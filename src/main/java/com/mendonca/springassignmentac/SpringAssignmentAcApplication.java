package com.mendonca.springassignmentac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com"})
@EntityScan("com.mendonca.springassignmentac.entity")
@EnableJpaRepositories("com.mendonca.springassignmentac.repository")
public class SpringAssignmentAcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringAssignmentAcApplication.class, args);
	}
}

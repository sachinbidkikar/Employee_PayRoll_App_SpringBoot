package com.springboot.payrollApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j  //used to create custom logs as this annotation helps to save, create custom logs by setting different msgs for logs like WARN,ERROR, DEBUG. in application.properties.
public class EmployeePayRollAppApplication {

	public static void main(String[] args) {

	ApplicationContext context =  SpringApplication.run(EmployeePayRollAppApplication.class, args);
		log.info("Employee Payroll App Started in {} environment", context.getEnvironment().getProperty("environment"));
		log.info("Employee payroll App Database User is {}", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}

package com.example.lottery.config;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.lottery.service.RandomNumberService;

@Configuration
@ComponentScan("com.example.lottery.service")
public class AppConfig {

	@Autowired
	private List<RandomNumberService> randomNumberServices;
	@Autowired
	private Map<String, RandomNumberService> randomNumberServicesMap;


	@PostConstruct
	public void init() {
		randomNumberServices.stream()
		                     .map(Object::getClass)
		                     .map(Class::getName)
		                     .forEach(System.err::println);
		randomNumberServicesMap.forEach(
				(beanName, bean)->System.err.printf("%s: %s\n",
						beanName, bean.getClass().getName()));
	}

}

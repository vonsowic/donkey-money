package com.iobestgroup.donkeymoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:application-database.properties")
})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

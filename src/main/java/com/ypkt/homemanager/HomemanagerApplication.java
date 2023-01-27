package com.ypkt.homemanager;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomemanagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HomemanagerApplication.class, args);
	}
	

	
	@Override
	public void run(String... args) throws Exception {}

}

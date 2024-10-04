package com.qima.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.qima.challenge.config.DataLoader;

@SpringBootApplication
@EnableWebMvc
public class ChallengeQimaBackendApplication implements WebMvcConfigurer, CommandLineRunner {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD");
	}
	
    @Autowired
    private DataLoader dataLoader;

    public static void main(String[] args) {
        SpringApplication.run(ChallengeQimaBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dataLoader.loadData(); 
        System.out.println("Products and categories loaded successfully!");
    }
}

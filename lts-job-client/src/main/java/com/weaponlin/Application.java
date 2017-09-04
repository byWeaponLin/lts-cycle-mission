package com.weaponlin;


import com.github.ltsopensource.spring.boot.annotation.EnableJobClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableJobClient
@ComponentScan("com.weaponlin")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

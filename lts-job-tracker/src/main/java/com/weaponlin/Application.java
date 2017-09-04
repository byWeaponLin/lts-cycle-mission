package com.weaponlin;

import com.github.ltsopensource.spring.boot.annotation.EnableJobTracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableJobTracker
@ComponentScan("com.weaponlin")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

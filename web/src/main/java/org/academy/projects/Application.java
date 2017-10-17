package org.academy.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/application.properties")
@ComponentScan(basePackages = "org.academy.projects")
public class Application {

    public static void main(String...args){
        SpringApplication.run(Application.class, args);
    }
}

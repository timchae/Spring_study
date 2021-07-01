package com.blog.blogprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogpracApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogpracApplication.class, args);
    }

}

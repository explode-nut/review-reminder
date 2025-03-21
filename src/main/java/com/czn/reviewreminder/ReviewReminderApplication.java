package com.czn.reviewreminder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czn.reviewreminder.mvc.mapper")
public class ReviewReminderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewReminderApplication.class, args);
    }

}

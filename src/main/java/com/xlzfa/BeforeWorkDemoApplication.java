package com.xlzfa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.xlzfa", "com.xlzfa.mapper"})

@MapperScan("com.xlzfa.mapper")
public class BeforeWorkDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeforeWorkDemoApplication.class, args);
    }

}




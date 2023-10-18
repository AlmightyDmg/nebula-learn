package com.dmg.nebulalearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class NebulaLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(NebulaLearnApplication.class, args);
    }

}

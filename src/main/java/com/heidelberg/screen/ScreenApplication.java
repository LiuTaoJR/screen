package com.heidelberg.screen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.heidelberg.screen.mapper")
@Slf4j
public class ScreenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreenApplication.class, args);
        log.info("screen启动成功");
    }

}

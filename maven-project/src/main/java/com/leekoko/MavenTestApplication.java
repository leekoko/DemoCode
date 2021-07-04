package com.leekoko;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StopWatch;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class MavenTestApplication {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        SpringApplication.run(MavenTestApplication.class, args);
        stopWatch.stop();
        log.info("maven-project服务启动成功，启动耗时{}s", stopWatch.getTotalTimeSeconds());
    }

}

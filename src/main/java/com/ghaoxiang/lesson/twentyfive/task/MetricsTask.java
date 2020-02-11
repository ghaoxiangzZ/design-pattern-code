package com.ghaoxiang.lesson.twentyfive.task;

import com.ghaoxiang.lesson.twentyfive.service.MetricsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName MetricsTask.java
 * @Description 定时任务
 * @createTime 2020年02月11日 23:30:00
 */
@Slf4j
@Configuration
@EnableScheduling
public class MetricsTask {

    @Autowired
    private MetricsService metricsService;

    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        log.info("开始执行任务......");
        String result = metricsService.startRepeatedReport();
        log.info("任务执行结果result={}", result);
        log.info("任务执行完毕......");
    }
}

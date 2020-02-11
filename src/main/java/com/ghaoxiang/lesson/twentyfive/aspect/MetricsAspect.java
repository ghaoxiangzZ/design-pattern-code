package com.ghaoxiang.lesson.twentyfive.aspect;

import com.ghaoxiang.lesson.twentyfive.service.MetricsService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName MetricsAspect.java
 * @Description 统计方法切面
 * @createTime 2020年02月11日 18:48:00
 */
@Aspect
@Component
@Slf4j
public class MetricsAspect {

    @Autowired
    private MetricsService metricsService;

    // 定义切点
    @Pointcut("@annotation(com.ghaoxiang.lesson.twentyfive.annotation.Metrics)")
    public void metricsPointCut() {
    }

    /*
     * @title saveLog
     * @description 环切
     * @author haoxiang_guo
     * @param [pJoinPoint, log]
     * @updateTime 2020-02-11 18:59:08
     * @return java.lang.Object
     * @throws
     */
    @Around("metricsPointCut()")
    public Object metricsMethod(ProceedingJoinPoint pjp) {
        Object result = null;
        String methodName = pjp.getSignature().getName();
        long start = System.currentTimeMillis();
        try {
            metricsService.recordResponseTime(methodName, start);
            result = pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            log.error("执行出错......" + throwable);
        }
        long end = System.currentTimeMillis();
        metricsService.recordResponseTime(methodName, end - start);
        return result;
    }
}

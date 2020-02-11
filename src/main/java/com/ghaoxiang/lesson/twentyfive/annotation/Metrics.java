package com.ghaoxiang.lesson.twentyfive.annotation;

import java.lang.annotation.*;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName Metric.java
 * @Description 自定义注解
 * @createTime 2020年02月11日 18:45:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Metrics {
}

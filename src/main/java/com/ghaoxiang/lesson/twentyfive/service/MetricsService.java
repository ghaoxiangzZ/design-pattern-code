package com.ghaoxiang.lesson.twentyfive.service;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName MetricsService.java
 * @Description 用户注册行为统计接口
 * @createTime 2020年02月11日 18:10:00
 */
public interface MetricsService {

    /*
     * @title recordResponseTime
     * @description 记录响应时间
     * @author haoxiang_guo
     * @param [apiName, responseTime]
     * @updateTime 2020-02-11 19:06:12
     * @return void
     * @throws
     */
    void recordResponseTime(String apiName, double responseTime);

    /*
     * @title recordTimestamp
     * @description 记录请求时间
     * @author haoxiang_guo
     * @param [apiName, timestamp]
     * @updateTime 2020-02-11 19:06:15
     * @return void
     * @throws
     */
    void recordTimestamp(String apiName, double timestamp);

    /*
     * @title startRepeatedReport
     * @description 统计方法
     * @author haoxiang_guo
     * @param []
     * @updateTime 2020-02-11 23:33:56
     * @return java.lang.String
     * @throws
     */
    String startRepeatedReport();
}

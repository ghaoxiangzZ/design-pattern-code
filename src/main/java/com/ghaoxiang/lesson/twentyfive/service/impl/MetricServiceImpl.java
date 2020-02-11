package com.ghaoxiang.lesson.twentyfive.service.impl;

import com.ghaoxiang.lesson.twentyfive.service.MetricsService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName MetricServiceImpl.java
 * @Description 聚合统计实现类
 * @createTime 2020年02月11日 18:11:00
 */
@Slf4j
@Service
public class MetricServiceImpl implements MetricsService {

    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();

    @Override
    public void recordResponseTime(String apiName, double responseTime) {
        log.info("recordResponseTime开始执行...... apiName={}, responseTime={}", apiName, responseTime);
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    @Override
    public void recordTimestamp(String apiName, double timestamp) {
        log.info("recordTimestamp开始执行...... apiName={}, responseTime={}", apiName, timestamp);
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    @Override
    public String startRepeatedReport() {
        Gson gson = new Gson();
        Map<String, Map<String, Double>> stats = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
            String apiName = entry.getKey();
            List<Double> apiRespTimes = entry.getValue();
            stats.putIfAbsent(apiName, new HashMap<>());
            stats.get(apiName).put("max", max(apiRespTimes));
            stats.get(apiName).put("avg", avg(apiRespTimes));
        }
        for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
            String apiName = entry.getKey();
            List<Double> apiTimestamps = entry.getValue();
            stats.putIfAbsent(apiName, new HashMap<>());
            stats.get(apiName).put("count", (double) apiTimestamps.size());
        }
        return gson.toJson(stats);
    }

    /*
     * @title avg
     * @description 求平均值
     * @author haoxiang_guo
     * @param [apiRespTimes]
     * @updateTime 2020-02-11 18:29:51
     * @return java.lang.Double
     * @throws
     */
    private Double avg(List<Double> apiRespTimes) {
        return apiRespTimes.stream().mapToDouble(Number::doubleValue).average().getAsDouble();
    }

    /*
     * @title max
     * @description 求最大值
     * @author haoxiang_guo
     * @param [apiRespTimes]
     * @updateTime 2020-02-11 18:31:07
     * @return java.lang.Double
     * @throws
     */
    private Double max(List<Double> apiRespTimes) {
        return apiRespTimes.stream().mapToDouble(Number::doubleValue).max().getAsDouble();
    }
}

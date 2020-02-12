package com.ghaoxiang.lesson.twentyfive.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName MetricServiceImplTest.java
 * @Description MetricServiceImpl测试类
 * @createTime 2020年02月12日 16:44:00
 */
public class MetricServiceImplTest {
    @Mock
    Map<String, List<Double>> responseTimes;
    @Mock
    Map<String, List<Double>> timestamps;
    @Mock
    Logger log;
    @InjectMocks
    MetricServiceImpl metricServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRecordResponseTime() throws Exception {
        metricServiceImpl.recordResponseTime(Mockito.anyString(), System.currentTimeMillis());
    }

    @Test
    public void testRecordTimestamp() throws Exception {
        metricServiceImpl.recordTimestamp(Mockito.anyString(), System.currentTimeMillis());
    }

    @Test
    public void testStartRepeatedReport() throws Exception {
        String result = metricServiceImpl.startRepeatedReport();
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
package com.ghaoxiang.lesson.twentyfive.aspect;

import com.ghaoxiang.lesson.twentyfive.service.MetricsService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName MetricsAspectTest.java
 * @Description MetricsAspect测试类
 * @createTime 2020年02月12日 16:57:00
 */
public class MetricsAspectTest {
    @Mock
    MetricsService metricsService;
    @Mock
    Logger log;
    @InjectMocks
    MetricsAspect metricsAspect;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMetricsPointCut() throws Exception {
        metricsAspect.metricsPointCut();
    }

    @Test
    public void testMetricsMethod() throws Exception {
        Object result = metricsAspect.metricsMethod(Mockito.any(ProceedingJoinPoint.class));
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
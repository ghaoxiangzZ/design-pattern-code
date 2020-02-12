package com.ghaoxiang.lesson.twentyfive.controller;

import com.ghaoxiang.lesson.twentyfive.vo.UserVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName UserControllerTest.java
 * @Description UserController测试类
 * @createTime 2020年02月12日 16:44:00
 */
public class UserControllerTest {
    @Mock
    Logger log;
    @InjectMocks
    UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegister() throws Exception {
        UserVO result = userController.register("haoxiang_guo", "haoxiang");
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void testLogin() throws Exception {
        boolean result = userController.login("haoxiang_guo", "haoxiang");
        Assert.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
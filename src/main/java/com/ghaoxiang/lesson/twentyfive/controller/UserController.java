package com.ghaoxiang.lesson.twentyfive.controller;

import com.ghaoxiang.lesson.twentyfive.annotation.Metrics;
import com.ghaoxiang.lesson.twentyfive.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description 用户相关API，配合实现接口聚合统计功能
 * @createTime 2020年02月11日 17:35:00
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    /*
     * @title register
     * @description 用户注册
     * @author haoxiang_guo
     * @param [username, password]
     * @updateTime 2020-02-11 18:07:59
     * @return com.ghaoxiang.lesson.twentyfive.vo.UserVO
     * @throws
     */
    @Metrics
    @PostMapping("/register")
    public UserVO register(String username, String password) {
        // 模拟用户注册操作
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        userVO.setPassword(password);
        log.info("用户注册成功......username={}, password={}", username, password);
        return userVO;
    }

    /*
     * @title login
     * @description 用户登录
     * @author haoxiang_guo
     * @param [username, password]
     * @updateTime 2020-02-11 18:08:37
     * @return boolean
     * @throws
     */
    @Metrics
    @PostMapping("/login")
    public boolean login(String username, String password) {
        // 模拟用户登录操作
        log.info("用户登录成功......username={}, password={}", username, password);
        // 省略登录校验业务
        return Boolean.TRUE;
    }
}

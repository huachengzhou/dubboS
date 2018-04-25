package com.blue.consumer;

import com.blue.domin.User;
import com.blue.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by 13426 on 2018/4/25.
 */
@Component(value = "userConsumer")
public class UserConsumer {

    @com.alibaba.dubbo.config.annotation.Reference(version = "1.0.0")
    private UserService userService;

    public void add(User user,String... rids){
        userService.insert(user,rids);
    }

    public User login(String username){
        return userService.login(username);
    }
}

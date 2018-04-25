package com.blue.service.impl;

import com.blue.dao.UserMapper;
import com.blue.domin.Login_log;
import com.blue.domin.User;
import com.blue.exception.ServiceException;
import com.blue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service(value = "userService")
@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> find(Map<String, Object> map) throws ServiceException {
        return userMapper.find(map);
    }


    @Override
    public User get(String id) throws ServiceException {
        return userMapper.get(id);
    }

    @Override
    public void insert(User user, String... rids) throws ServiceException {
        userMapper.insert(user);
        Map<String, Object> map = null;
        for (String s : rids) {//不提取出来
            map = new HashMap<>();
            map.put("rid", s);
            map.put("user", user);
            userMapper.insertUserRole(map);
        }
    }

    @Override
    public void update(User user, String... rids) throws ServiceException {
        String[] uids = {user.getUid()};
        Map<String, Object> map = new HashMap<>();
        map.put("ids", uids);
        userMapper.deleteUser_Role(map);
        update(user);
        for (String s : rids) {//选择不提出来,涉及到了三个数据库语句有点复杂
            map = new HashMap<>();
            map.put("rid", s);
            map.put("user", user);
            userMapper.insertUserRole(map);
        }
    }


    public void update(User user) throws ServiceException {
        userMapper.update(user);
    }

    @Override
    public void delete(String... ids) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        userMapper.delete(map);
        userMapper.deleteUser_Role(map);
    }

    @Override
    public User login(String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        try {
            return userMapper.login(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getPassword(String username) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        User user = userMapper.login(map);
        if (user != null) {
            String id = user.getUid();
            String password = user.getPassword();
//            password = ZhouBase64.isDecode(password);
            int index = id.length();
            password = password.substring(index, password.length());
            user.setPassword(password);
        }
        return user;
    }

    @Override
    public void insert(User user, String host) throws ServiceException {
        String sql = "insert into login_log_p(IP_ADDRESS,LOGIN_LOG_ID,LOGIN_NAME,LOGIN_ID,LOGIN_TIME)\n" +
                "values(?,?,?,?,(select NOW()))";
        Login_log login_log = new Login_log();
        login_log.setId(UUID.randomUUID().toString());
        login_log.setName(user.getUsername());
        jdbcTemplate.update(sql,host,login_log.getId(),login_log.getName(),user.getUid());
    }
}

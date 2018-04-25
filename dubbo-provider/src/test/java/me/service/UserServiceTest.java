package me.service;

import com.blue.common.pinyin4j.ChangeToPinYin;
import com.blue.domin.User;
import com.blue.service.RoleService;
import com.blue.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.UUID;

public class UserServiceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RoleService roleService = null;
    private UserService userService = null;
    private String[] ids = null;
    ChangeToPinYin changeToPinYin = new ChangeToPinYin();

    @Test
    public void insert() throws Exception {
        User user = new User();
        String id = UUID.randomUUID().toString();
        user.setUid(id);
        user.setLock_User(false);
        String name = "赵均";
        user.setName(name);
        user.setUsername(changeToPinYin.getStringPinYin(name));
        user.setOrganizationid("中石油");
        user.setPassword("123456");
        user.setTime(new Date(System.nanoTime()));
        user.setSalt(System.currentTimeMillis() + "");

        userService.insert(user, ids);
    }

    @Test
    public void login(){
        String username = "lisi";
        User user = userService.login(username);
        System.out.println(user);
    }

    @Before
    public void init() throws Exception {
        roleService = context.getBean(RoleService.class);
        userService = context.getBean(UserService.class);
        ids = new String[]{"9b4b14cf-fe0a-4690-bd8c-b2c0f0725f07"};//管理员角色
        ids = new String[]{"9ec81eb2-6cb2-4746-b843-84e6f1792349","8a1d172a-4bd9-4daa-a9c3-3583a6e6a6bc"};//普通角色
    }
}

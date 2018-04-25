package me.service;

import com.blue.domin.Privilege;
import com.blue.service.PrivilegeService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class PrivilegeServiceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private PrivilegeService privilegeService = null;

    @Test
    public void insert() throws Exception {
        String[] descriptions = {"管理员","普通用户","user:admin"};
        String[] privilege_names = {"user:select","user:save","user:remove","user:update"};
        boolean flag = true;
        if (flag){
            for (String p:privilege_names){
                Privilege privilege = new Privilege();
                privilege.setPid(UUID.randomUUID().toString());
                privilege.setDescription(descriptions[1]);
                privilege.setPrivilege_name(p);
                privilegeService.insert(privilege);
                logger.info(privilege + "");
            }
        }else {
            Privilege privilege = new Privilege();
            privilege.setPid(UUID.randomUUID().toString());
            privilege.setDescription(descriptions[0]);
            privilege.setPrivilege_name(descriptions[2]);
            privilegeService.insert(privilege);
            logger.info(privilege + "");
        }


    }

    @Test
    public void get(){
        String id = "61734863-4f77-4e31-98e0-69309665b89c";
        Privilege privilege = privilegeService.get(id);
        logger.info(""+privilege);
    }

    @Test
    public void list(){
        privilegeService.find(null).forEach(privilege -> System.out.println(privilege));
    }

    @Test
    public void remove(){
        String[] ids = {"","408347f6-d997-4911-820a-f6edfb7e28a6"};
        privilegeService.delete(ids);
    }

    @Before
    public void init() throws Exception {
        privilegeService = (PrivilegeService) context.getBean("privilegeService");
    }
}

package me.service;

import com.blue.common.pinyin4j.ChangeToPinYin;
import com.blue.domin.Privilege;
import com.blue.domin.Role;
import com.blue.service.PrivilegeService;
import com.blue.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

public class RoleServiceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RoleService roleService = null;
    private PrivilegeService privilegeService = null;
    private String[] ids = null;
    ChangeToPinYin changeToPinYin = new ChangeToPinYin();

    @Test
    public void insert() throws Exception {
        Role role = new Role();
        String id = UUID.randomUUID().toString();
        role.setRid(id);
        String description = "老师";
        role.setDescription(description);
        role.setRole_name(changeToPinYin.getStringPinYin(description));
        role.setAvailable(false);
        roleService.insert(role, ids);
        role = roleService.get(id);
        logger.info(role + "");
    }

    @Test
    public void remove(){

        String[] ids = {"b63dd960-19db-41e8-acad-6b801d60b7a8"};
        roleService.delete(ids);

    }


    @Before
    public void init() throws Exception {
        roleService = context.getBean(RoleService.class);
        privilegeService = (PrivilegeService) context.getBean("privilegeService");
        logger.info(roleService + "");
        List<Privilege> privileges = privilegeService.find(null);
        ids = new String[]{privileges.get(privileges.size()-1).getPid()};//管理员权限角色

//        int length = privileges.size()-1;//普通用户权限角色
//        ids = new String[length];
//        for (int i = 0; i < ids.length; i++) {
//            if (!privileges.get(i).getPrivilege_name().equals("user:admin")){
//                ids[i] = privileges.get(i).getPid();
//            }
//        }
    }
}

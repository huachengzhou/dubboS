package com.blue.service.impl;

import com.blue.dao.RoleMapper;
import com.blue.domin.Role;
import com.blue.exception.ServiceException;
import com.blue.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "roleService")
@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class RoleServiceImpl implements RoleService {

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private RoleMapper roleMapper;

    @Override
    public List<Role> find(Map map) throws ServiceException {
        return roleMapper.find(map);
    }

    @Override
    public Role get(String id) throws ServiceException {
        return roleMapper.get(id);
    }

    /**
     * @param entity
     * @throws ServiceException
     */
    @Override
    public void insert(Role entity, String... pids) throws ServiceException {
        roleMapper.insert(entity);
        Map<String, Object> map = null;
        for (String s : pids) {//不提取出来
            map = new HashMap<>();
            map.put("pid", s);
            map.put("role", entity);
            roleMapper.insertRolePrivilege(map);
        }
    }

    /**
     * @param entity
     * @throws ServiceException
     */
    @Override
    public void update(Role entity, String... pids) throws ServiceException {
        String[] rids = {entity.getRid()};
        Map<String, Object> map = new HashMap<>();
        map.put("ids", rids);
        roleMapper.deletePrivilege_role(map);
        update(entity);
        for (String s : pids) {//选择不提出来,涉及到了三个数据库语句有点复杂
            map = new HashMap<>();
            map.put("pid", s);
            map.put("role", entity);
            roleMapper.insertRolePrivilege(map);
        }
    }

    public void update(Role role) throws ServiceException {
        roleMapper.update(role);
    }


    @Override
    public void delete(String... ids) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        roleMapper.delete(map);
        roleMapper.deletePrivilege_role(map);
    }
}

package com.blue.service.impl;

import com.blue.dao.PrivilegeMapper;
import com.blue.domin.Privilege;
import com.blue.exception.ServiceException;
import com.blue.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "privilegeService")
@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class PrivilegeServiceImpl implements PrivilegeService

{
    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> find(Map map) throws ServiceException {
        return privilegeMapper.find(map);
    }

    @Override
    public Privilege get(String id) throws ServiceException {
        return privilegeMapper.get(id);
    }

    @Override
    public void insert(Privilege entity) throws ServiceException {
        privilegeMapper.insert(entity);
    }

    @Override
    public void update(Privilege entity) throws ServiceException {
        privilegeMapper.update(entity);
    }


    @Override
    public void delete(String... ids) throws ServiceException {
        if (ids.length==1){
            privilegeMapper.deleteById(ids[0]);
        }else {
            Map<String, Object> map = new HashMap<>();
            map.put("ids", ids);
            privilegeMapper.delete(map);
        }
    }
}

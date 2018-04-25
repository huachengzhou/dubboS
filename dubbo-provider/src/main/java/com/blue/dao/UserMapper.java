package com.blue.dao;


import com.blue.domin.User;
import com.blue.exception.MapperException;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> find(Map<String, Object> map) throws MapperException;

    public User get(String id) throws MapperException;

    public void insert(User user) throws MapperException;

    /**
     * user,rid
     *
     * @param map
     * @throws Exception
     */
    public void insertUserRole(Map<String, Object> map) throws MapperException;


    /**
     * param ids
     *
     * @throws MapperException
     */
    public void delete(Map<String, Object> map) throws MapperException;

    /**
     * ids
     *
     * @param map
     * @throws MapperException
     */

    public void deleteUser_Role(Map<String, Object> map) throws MapperException;

    public void update(User user) throws MapperException;

    /**
     * username and password
     *
     * @param map
     * @return
     * @throws MapperException
     */
    public User login(Map<String, Object> map) throws MapperException;
}

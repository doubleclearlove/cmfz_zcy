package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);
    void deleteUser(String id);
    void updateUser(User user);
    List<User> queryallUser();
    User queryoneUser(String id);
}

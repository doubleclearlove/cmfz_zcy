package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(String id);
    void motifyUser(User user);
    List<User> findallUser();
    User findoneUser(String id);
}

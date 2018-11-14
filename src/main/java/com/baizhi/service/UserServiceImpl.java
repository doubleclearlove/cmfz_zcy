package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setCreateDate(new Date());
        user.setPassword(Md5Util.getMd5Password(user.getPassword()));
        userDao.insertUser(user);
    }

    @Override
    public void removeUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public void motifyUser(User user) {
        user.setPassword(Md5Util.getMd5Password(user.getPassword()));
        userDao.updateUser(user);
    }

    @Override
    public List<User> findallUser() {
        return userDao.queryallUser();
    }

    @Override
    public User findoneUser(String id) {
        return userDao.queryoneUser(id);
    }
}

package com.baizhi.dao;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminDao {
    void insertAdmin(Admin admin);
    void deleteAdmin(String id);
    void updateAdmin(Admin admin);
    List<Admin> queryallAdmin();
    Admin queryoneAdmin(Admin admin);
}

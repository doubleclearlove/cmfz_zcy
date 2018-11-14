package com.baizhi.service;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminService {
    void addAdmin(Admin admin);
    void removeAdmin(String id);
    void motifyAdmin(Admin admin);
    List<Admin> findallAdmin();
    Admin findoneAdmin(Admin admin);
}

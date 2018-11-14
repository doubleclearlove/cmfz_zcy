package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Override
    public void addAdmin(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        adminDao.insertAdmin(admin);
    }

    @Override
    public void removeAdmin(String id) {
        adminDao.deleteAdmin(id);
    }

    @Override
    public void motifyAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public List<Admin> findallAdmin() {
        return adminDao.queryallAdmin();
    }

    @Override
    public Admin findoneAdmin(Admin admin) {
        return adminDao.queryoneAdmin(admin);
    }
}

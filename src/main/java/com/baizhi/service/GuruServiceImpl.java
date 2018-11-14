package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GuruServiceImpl implements GuruService{
    @Autowired
    private GuruDao guruDao;

    @Override
    public void addGuru(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insertGuru(guru);
    }

    @Override
    public void removeGuru(String id) {
        guruDao.deleteGuru(id);
    }

    @Override
    public void motifyGuru(Guru guru) {
        guruDao.updateGuru(guru);
    }

    @Override
    public List<Guru> queryallGuru() {
        return guruDao.queryallGuru();
    }
}

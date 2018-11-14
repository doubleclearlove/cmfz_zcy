package com.baizhi.dao;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruDao {
    void insertGuru(Guru guru);
    void deleteGuru(String id);
    void updateGuru(Guru guru);
    List<Guru> queryallGuru();

}

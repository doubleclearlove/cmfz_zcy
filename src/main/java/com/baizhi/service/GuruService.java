package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    void addGuru(Guru guru);
    void removeGuru(String id);
    void motifyGuru(Guru guru);
    List<Guru> queryallGuru();
}

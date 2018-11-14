package com.baizhi.service;

import com.baizhi.dao.CounterDao;
import com.baizhi.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CounterServiceImpl  implements CounterService{
    @Autowired
    private CounterDao counterDao;
    @Override
    public List<Counter> findallCounter() {
        return counterDao.queryallCounter();
    }

    @Override
    public void addCounter(Counter counter) {
        counter.setId(UUID.randomUUID().toString());
        counter.setRecordDate(new Date());
        counterDao.insertCounter(counter);
    }

    @Override
    public void removeCounter(String id) {
        counterDao.deleteCounter(id);
    }
}

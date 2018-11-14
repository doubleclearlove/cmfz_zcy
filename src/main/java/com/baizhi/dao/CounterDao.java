package com.baizhi.dao;

import com.baizhi.entity.Counter;

import java.util.List;

public interface CounterDao {
        List<Counter> queryallCounter();
        void insertCounter(Counter counter);
        void deleteCounter(String id);
}

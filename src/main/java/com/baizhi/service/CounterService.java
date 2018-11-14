package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;

public interface CounterService {
    List<Counter> findallCounter();
    void addCounter(Counter counter);
    void removeCounter(String id);
}

package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService {
    void addMenu(Menu menu);
    void removeMenu(String id);
    void motifyMenu(Menu menu);
    List<Menu> findallMenu();
    Menu findoneMenu(String id);
}

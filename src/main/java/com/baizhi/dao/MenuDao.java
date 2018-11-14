package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuDao {
    void insertMenu(Menu menu);
    void deleteMenu(String id);
    void updateMenu(Menu menu);
    List<Menu> queryallMenu();
    Menu queryoneMenu(String id);
}

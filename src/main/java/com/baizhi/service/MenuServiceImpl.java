package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl  implements MenuService{
    @Autowired
    private MenuDao menuDao;

    @Override
    public void addMenu(Menu menu) {
        menuDao.insertMenu(menu);
    }

    @Override
    public void removeMenu(String id) {
        menuDao.deleteMenu(id);
    }

    @Override
    public void motifyMenu(Menu menu) {
        menuDao.updateMenu(menu);
    }

    @Override
    public List<Menu> findallMenu() {
        return menuDao.queryallMenu();
    }

    @Override
    public Menu findoneMenu(String id) {
        return menuDao.queryoneMenu(id);
    }
}

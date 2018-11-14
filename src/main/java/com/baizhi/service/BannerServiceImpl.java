package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDao bannerDao;

    @Override
    public void addBanner(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        banner.setCreateDate(new Date());
        banner.setStatus("正常");
        bannerDao.insertBanner(banner);
    }

    @Override
    public void removeBanner(String id) {
        bannerDao.deleteBanner(id);
    }

    @Override
    public void motifyBanner(Banner banner) {
        bannerDao.updateBanner(banner);
    }

    @Override
    public List<Banner> findallBanner() {
        return bannerDao.queryallBanner();
    }

    @Override
    public Banner findoneBanner(String id) {
        return bannerDao.queryoneBanner(id);
    }
}

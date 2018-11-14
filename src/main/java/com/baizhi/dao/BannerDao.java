package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerDao {
    void insertBanner(Banner banner);
    void deleteBanner(String id);
    void updateBanner(Banner banner);
    List<Banner> queryallBanner();
    Banner queryoneBanner(String id);

}

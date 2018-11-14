package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    void addBanner(Banner banner);
    void removeBanner(String id);
    void motifyBanner(Banner banner);
    List<Banner> findallBanner();
    Banner findoneBanner(String id);
}

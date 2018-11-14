package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("showonebanner")
    public @ResponseBody Banner showOneBanner(String id){
        return bannerService.findoneBanner(id);
    }

    @RequestMapping("showallbanner")
    public @ResponseBody List<Banner> showAllBanner(){
        return bannerService.findallBanner();
    }

    @RequestMapping("addbanner")
    public void addBanner(Banner banner, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(file);
        String realpath=request.getSession().getServletContext().getRealPath("back/bannerimg/addimg");
        file.transferTo(new File(realpath,file.getOriginalFilename()));
        banner.setImgPath("/back/bannerimg/addimg/"+file.getOriginalFilename());
        bannerService.addBanner(banner);
    }
    @RequestMapping("deletebanner")
    public @ResponseBody void deleteBanner(String id){
        bannerService.removeBanner(id);
    }
    @RequestMapping("updatebanner")
    public void updateBanner(Banner banner){
        System.out.println(banner);
        bannerService.motifyBanner(banner);
    }
}

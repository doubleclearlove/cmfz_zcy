package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("cmfz")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(Admin admin,HttpServletRequest request,String code){
        String validationCode = (String) request.getSession().getAttribute("validationCode");
        if(validationCode.equals(code)){
            admin.setPassword(Md5Util.getMd5Password(admin.getPassword()));
            Admin admin1 = adminService.findoneAdmin(admin);
            request.getSession().setAttribute("admin",admin1);
            if(admin1==null){
                return "back/login";
            }else{
                return "back/main/main";
            }
        }else{
            return "back/login";
        }
    }
@RequestMapping("updateadmin")
    public String  updateAdmin(Admin admin,String newpassword){
        admin.setPassword(Md5Util.getMd5Password(newpassword));
        System.out.println(admin.getPassword());
        adminService.motifyAdmin(admin);
        return "back/login";
}
@RequestMapping("admingoout")
    public String gouutAdmin(HttpServletRequest request){
        request.getSession().invalidate();
        return "back/login";
}






}

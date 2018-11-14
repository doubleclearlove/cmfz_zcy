package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("showall")
    public @ResponseBody List<User> showall(){
        return userService.findallUser();
    }

    @RequestMapping("adduser")
    public @ResponseBody void addUser(User user){
        userService.addUser(user);
    }
    @RequestMapping("deleteuser")
    public @ResponseBody void deleteUser(String id){
        userService.removeUser(id);
    }
    @RequestMapping("updateuser")
    public @ResponseBody void updateUser(User user){
        userService.motifyUser(user);
    }
    @RequestMapping("queryoneuser")
    public @ResponseBody User qoeryoneUser(String id){
        return userService.findoneUser(id);
    }
}

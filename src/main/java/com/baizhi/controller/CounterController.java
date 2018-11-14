package com.baizhi.controller;

import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("counter")
public class CounterController {
    @Autowired
    private CounterService  counterService;

    @RequestMapping("queryallcounter")
    public @ResponseBody List<Counter> queryallCounter(){
        return counterService.findallCounter();
    }
    @RequestMapping("addcounter")
    public @ResponseBody void addCounter(Counter  counter){
        counterService.addCounter(counter);
    }
    @RequestMapping("deletecounter")
    public @ResponseBody void deleteCounter(String id){
        counterService.removeCounter(id);
    }
}

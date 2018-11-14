package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("addguru")
    public @ResponseBody void addGuru(Guru guru){
        System.out.println(guru);
        guruService.addGuru(guru);
    }
    @RequestMapping("deleteguru")
    public @ResponseBody void deleteGuru(String id){
        guruService.removeGuru(id);
    }
    @RequestMapping("updateguru")
    public @ResponseBody void updateGuru(Guru guru){
        guruService.motifyGuru(guru);
    }
    @RequestMapping("queryallguru")
    public @ResponseBody List<Guru> queryallGuru(){
        return guruService.queryallGuru();
    }
}

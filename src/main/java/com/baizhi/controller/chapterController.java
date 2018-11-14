package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.Mp3Util;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("chapter")
public class chapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("addchapter")
    public @ResponseBody void addChapter(String album_id,Chapter chapter,MultipartFile file, HttpServletRequest request) throws Exception {
        String realpath=request.getSession().getServletContext().getRealPath("back/chapter");
        file.transferTo(new File(realpath,file.getOriginalFilename()));
        System.out.println("文件名"+file);
        chapter.setSize(Mp3Util.getSize(realpath,file.getOriginalFilename()));
        System.out.println("大小"+Mp3Util.getSize(realpath,file.getOriginalFilename()));
        chapter.setDuration(Mp3Util.getDuration(realpath,file.getOriginalFilename()));
        System.out.println("时长"+Mp3Util.getDuration(realpath, file.getOriginalFilename()));
        chapter.setAlbum_id(album_id);
        chapter.setDownPath(file.getOriginalFilename());
        System.out.println("11111"+chapter);
        chapterService.addChapter(chapter);

    }
    @RequestMapping("deletechapter")
    public @ResponseBody void deleteChapter(String id){
        chapterService.removeChapter(id);
    }
    @RequestMapping("queryallchapter")
    public @ResponseBody List<Chapter> queryallChapter(){
        return chapterService.findallChapter();
    }
    @RequestMapping("queryonechapter")
    public @ResponseBody Chapter queryoneChapter(String id){
        return chapterService.findoneChapter(id);
    }
    @RequestMapping("downloadchapter")
    public @ResponseBody void downloadChapter(HttpServletResponse response,HttpServletRequest request, String filename, String openStyle)throws Exception {
        System.out.println(filename);
        System.out.println(openStyle);
        openStyle="attachment";
        String realpath=request.getSession().getServletContext().getRealPath("back/chapter");
        FileInputStream fis=new FileInputStream(new File(realpath,filename));
        response.setHeader("content-disposition",openStyle+";fileName="+URLEncoder.encode(filename, "UTF-8"));
        ServletOutputStream sos=response.getOutputStream();
        IOUtils.copy(fis, sos);
        IOUtils.closeQuietly(fis);//安静关流
        IOUtils.closeQuietly(sos);
    }
}

package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("queryallalbum")
    public @ResponseBody List<Album> showall(){
    return albumService.findallAlbum();
    }
    @RequestMapping("addalbum")
    public @ResponseBody void addAlbum(Album album){
        System.out.println(album);
        albumService.addAlbum(album);
    }
    @RequestMapping("deletealbum")
    public @ResponseBody void deleteAlbum(String id){
        albumService.removeAlbum(id);
    }
    @RequestMapping("queryonealbum")
    public @ResponseBody Album queryoneAlbum(String id){
        return albumService.findoneAlbum(id);
    }
}

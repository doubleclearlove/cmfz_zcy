package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumDao albumDao;
    @Override
    public void addAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setPublishDate(new Date());
        album.setStar(4);
        albumDao.insertAlbum(album);
    }

    @Override
    public void removeAlbum(String id) {
        albumDao.deleteAlbum(id);
    }

    @Override
    public List<Album> findallAlbum() {
        return albumDao.queryallAlbum();
    }

    @Override
    public Album findoneAlbum(String id) {
        return albumDao.queryoneAlbum(id);
    }
}

package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDao {
    void insertAlbum(Album album);
    void deleteAlbum(String id);
    List<Album> queryallAlbum();
    Album queryoneAlbum(String id);
}

package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    void addAlbum(Album album);
    void removeAlbum(String id);
    List<Album> findallAlbum();
    Album findoneAlbum(String id);
}

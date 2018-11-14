package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterDao {
    void insertChapter(Chapter chapter);
    void deleteChapter(String id);
    List<Chapter> queryallChapter();
    Chapter queryoneChapter(String id);
}

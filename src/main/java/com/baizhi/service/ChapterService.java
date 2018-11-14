package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    void addChapter(Chapter chapter);
    void removeChapter(String chapter_id);
    List<Chapter> findallChapter();
    Chapter findoneChapter(String chapter_id);
}

package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private ChapterDao chapterDao;

    @Override
    public void addChapter(Chapter chapter) {
        chapter.setChapter_id(UUID.randomUUID().toString());
        chapter.setUploadTime(new Date());
        System.out.println("service中的"+chapter);
        chapterDao.insertChapter(chapter);
    }

    @Override
    public void removeChapter(String chapter_id) {
        chapterDao.deleteChapter(chapter_id);
    }

    @Override
    public List<Chapter> findallChapter() {
        return chapterDao.queryallChapter();
    }

    @Override
    public Chapter findoneChapter(String chapter_id) {
        return chapterDao.queryoneChapter(chapter_id);
    }
}

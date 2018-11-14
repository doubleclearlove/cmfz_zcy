package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findallCourse() {
        return courseDao.queryallCourse();
    }

    @Override
    public void addCourse(Course course) {
        courseDao.insertCourse(course);
    }

    @Override
    public void removeCurse(String id) {
        courseDao.deleteCourse(id);
    }
}

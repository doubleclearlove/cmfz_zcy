package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findallCourse();
    void addCourse(Course course);
    void removeCurse(String id);
}

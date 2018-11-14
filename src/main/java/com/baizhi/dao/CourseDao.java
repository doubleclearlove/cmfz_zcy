package com.baizhi.dao;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> queryallCourse();
    void insertCourse(Course course);
    void deleteCourse(String id);
}

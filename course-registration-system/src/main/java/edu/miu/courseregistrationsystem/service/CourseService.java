package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.entity.Course;

import java.util.List;


public interface CourseService{
    public CourseDto createCourse(CourseDto courseDto);
    public CourseDto getCourse(long id);
    public CourseDto updateCourse(long id, CourseDto courseDto);
    public void deleteCourse(long id);
    public List<Course> getAllCourses();
}

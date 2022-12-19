package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.entity.Course;

import edu.miu.courseregistrationsystem.mapper.CourseMapper;
import edu.miu.courseregistrationsystem.repository.CourseRepository;
import edu.miu.courseregistrationsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseMapper courseMapper;
    @Autowired
    CourseRepository courseRepository;
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.getCourseFromCourseDto(courseDto);
        courseRepository.save(course);
        return courseDto;
    }

    public CourseDto getCourse(long id) {
        Course course = courseRepository.findById(id).get();
        CourseDto courseDto = courseMapper.getCourseDtoFromCourse(course);
        return  courseDto;
    }

    public CourseDto updateCourse(long id, CourseDto courseDto) {
        Course course = courseMapper.getCourseFromCourseDto(courseDto);
        courseRepository.save(course);
        return courseDto;
    }

    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}

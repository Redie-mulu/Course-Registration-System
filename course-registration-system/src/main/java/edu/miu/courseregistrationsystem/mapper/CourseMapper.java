package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.entity.Course;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "Spring")
public interface CourseMapper {
    public Course getCourseFromCourseDto(CourseDto courseDto);

    public CourseDto getCourseDtoFromCourse(Course course);

    public List<CourseDto> getCourseDtoFromCourses(List<Course> course);

    public List<Course> getCourseFromCourseDto(List<CourseDto> courseDto);
}

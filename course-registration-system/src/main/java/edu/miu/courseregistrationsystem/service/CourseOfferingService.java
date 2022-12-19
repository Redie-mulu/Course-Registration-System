package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;

public interface CourseOfferingService {
    public CourseOfferingDto createCourseOffering(CourseOfferingDto courseOfferingDto);
    public CourseOfferingDto getCourseOffering(long id);
    public CourseOfferingDto updateCourseOffering(long id, CourseOfferingDto courseOfferingDto);
    public void deleteCourseOffering(long id);

}

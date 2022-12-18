package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;

import java.util.ArrayList;
import java.util.List;

public class CourseOfferingMapper {
    public static CourseOffering getCourseOfferingFromCourseOfferingDto(CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = new CourseOffering();
        return courseOffering;
    }
    public static CourseOfferingDto getCourseOfferingDtoFromCourseOffering(CourseOffering courseOffering) {
        CourseOfferingDto courseOfferingDto = new CourseOfferingDto();
        return courseOfferingDto;
    }
    public static List<CourseOffering> getCourseOfferingsFromCourseOfferingDtos(List<CourseOfferingDto> courseOfferingDtos) {
        List<CourseOffering> courseOfferings = new ArrayList<>();
        return courseOfferings;
    }
    public static List<CourseOfferingDto> getCourseOfferingDtosFromCourseOfferings(List<CourseOffering> courseOfferings) {
        List<CourseOfferingDto> courseOfferingDtos = new ArrayList<>();
        return courseOfferingDtos;
    }
}

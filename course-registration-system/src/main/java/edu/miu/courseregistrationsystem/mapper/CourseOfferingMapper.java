package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 12:10 AM
 */
@Mapper(componentModel = "spring")
public interface CourseOfferingMapper {
    public CourseOffering getCourseOfferingFromCourseOfferingDto(CourseOfferingDto courseOfferingDto);
    public CourseOfferingDto getCourseOfferingDtoFromCourseOffering(CourseOffering courseOffering);
    public List<CourseOffering> getCourseOfferingsFromCourseOfferingDtos(List<CourseOfferingDto> courseOfferingDtos);
    public List<CourseOfferingDto> getCourseOfferingDtosFromCourseOfferings(List<CourseOffering> courseOfferings);
}

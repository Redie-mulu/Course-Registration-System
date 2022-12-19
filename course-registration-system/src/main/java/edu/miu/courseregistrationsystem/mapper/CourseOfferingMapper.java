package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "Spring")
public interface CourseOfferingMapper {
    public CourseOffering getCourseOfferingFromCourseOfferingDto(CourseOfferingDto courseOfferingDto);

    public CourseOfferingDto getCourseOfferingDtoFromCourseOffering(CourseOffering courseOffering);

    public List<CourseOfferingDto> getCourseOfferingDtoFromCourseOfferings(List<CourseOffering> courseOffering);

    public List<CourseOffering> getCourseOfferingsFromCourseOfferingDto(List<CourseOfferingDto> courseOfferingDto);
}

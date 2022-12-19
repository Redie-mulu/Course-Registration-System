package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.mapper.CourseOfferingMapper;
import edu.miu.courseregistrationsystem.repository.CourseOfferingRepository;
import edu.miu.courseregistrationsystem.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {
    private CourseOfferingMapper courseOfferingMapper;
    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Override
    public CourseOfferingDto createCourseOffering(CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = courseOfferingMapper.getCourseOfferingFromCourseOfferingDto(courseOfferingDto);
        courseOfferingRepository.save(courseOffering);
        return courseOfferingDto;
    }

    @Override
    public CourseOfferingDto getCourseOffering(long id) {
        CourseOffering courseOffering = courseOfferingRepository.findById(id).get();
        CourseOfferingDto courseOfferingDto = courseOfferingMapper.getCourseOfferingDtoFromCourseOffering(courseOffering);
        return  courseOfferingDto;
    }

    @Override
    public CourseOfferingDto updateCourseOffering(long id, CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = courseOfferingMapper.getCourseOfferingFromCourseOfferingDto(courseOfferingDto);
        courseOfferingRepository.save(courseOffering);
        return courseOfferingDto;
    }

    @Override
    public void deleteCourseOffering(long id) {courseOfferingRepository.deleteById(id);
    }

}

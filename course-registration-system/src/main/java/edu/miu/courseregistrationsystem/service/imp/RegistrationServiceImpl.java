package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.mapper.CourseOfferingMapper;
import edu.miu.courseregistrationsystem.repository.CourseOfferingRepository;
import edu.miu.courseregistrationsystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Feven
 * @version 1.0
 *@created 19-Dec-2022 6:00 PM
 */


@Service
public class RegistrationServiceImpl implements RegisterService {
    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    private CourseOfferingMapper courseOfferingMapper;

    @Override
    public List<CourseOffering> findAll() {
        return courseOfferingRepository.findAll();
    }

    @Override
    public CourseOffering findOne(Long id) {
        return courseOfferingRepository.findById(id).orElse(null);
    }

    @Override
    public CourseOffering update(CourseOfferingDto courseOfferingdto) {
        CourseOffering courseOffering = courseOfferingMapper.courseOfferingFromCourseOfferingDto(courseOfferingdto);
       return courseOfferingRepository.save(courseOffering);
    }

    @Override
    public void delete(Long id) {
        courseOfferingRepository.deleteById(id);
    }

    @Override
    public CourseOffering add(CourseOffering t) {
        return courseOfferingRepository.save(t);
    }

    @Autowired
    public void setCourseOfferingMapper(CourseOfferingMapper courseOfferingMapper) {
        this.courseOfferingMapper = courseOfferingMapper;
    }
}

package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Feven
@Service
public class CourseOfferingImpl implements RegisterService{
    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    @Override
    public List<CourseOffering> findAll() {
        return courseOfferingRepository.findAll();
    }

    @Override
    public CourseOffering findOne(Long id) {
        return courseOfferingRepository.findById(id).orElse(null);
    }

    @Override
    public CourseOffering update(CourseOffering courseOffering) {
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
}

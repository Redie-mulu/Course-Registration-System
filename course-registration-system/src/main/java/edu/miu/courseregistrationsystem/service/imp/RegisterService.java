package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.entity.CourseOffering;

import java.util.List;
//Feven
public interface RegisterService{

    public List<CourseOffering> findAll();
    public CourseOffering findOne(Long id);
    public CourseOffering update(CourseOffering courseOffering);
    public void delete(Long id);
    public CourseOffering add(CourseOffering t);
}

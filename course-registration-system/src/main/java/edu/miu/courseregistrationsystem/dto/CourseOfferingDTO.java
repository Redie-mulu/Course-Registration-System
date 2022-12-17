package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import edu.miu.courseregistrationsystem.entity.Course;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class CourseOfferingDTO {
    private String code;
    private long capacity;
    private long availableSeats;
    private String facultyInitial;

    private List<AcademicBlock> block = new ArrayList<>();

    private edu.miu.courseregistrationsystem.entity.Course course;


    public CourseOfferingDTO() {
    }

    public CourseOfferingDTO(String code, edu.miu.courseregistrationsystem.entity.Course course, long capacity, long availableSeats,
                          List<AcademicBlock> block, String facultyInitial) {
        this.code = code;
        this.course = course;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.block = block;
        this.facultyInitial = facultyInitial;
    }
    public long availableSeats(long numberOfStudents){
        return this.capacity - numberOfStudents;
    }

}

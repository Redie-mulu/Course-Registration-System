package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Course;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class CourseOfferingDto {
    private long id;
    private String code;
    private long capacity;
    private long availableSeats;
    private String initials;
    private List<AcademicBlockDto> block = new ArrayList<>();
    private Course course;
    private List<FacultyDto> staff = new ArrayList<>();
    private List<StudentDto> students = new ArrayList<>();


}

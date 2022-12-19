package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import edu.miu.courseregistrationsystem.entity.Course;
import edu.miu.courseregistrationsystem.entity.Faculty;
import edu.miu.courseregistrationsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import edu.miu.courseregistrationsystem.entity.Course;
import edu.miu.courseregistrationsystem.entity.Faculty;
import edu.miu.courseregistrationsystem.entity.Student;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseOfferingDto {
    private long id;
    private String code;
    private long capacity;
    private long availableSeats;
    private String initials;
    private List<AcademicBlockDto> block;
    private CourseDto courseDto;
    private List<FacultyDto> staff;
    private List<StudentDto> students;


}

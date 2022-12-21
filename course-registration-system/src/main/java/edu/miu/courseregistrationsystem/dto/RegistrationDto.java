package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Feven
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDto {

    private long id;
//    private String code;
//    private long capacity;
//    private long availableSeats;
//    private String initials;
//    private List<AcademicBlock> block = new ArrayList<>();
//    private Course course;
//    private List<Faculty> staff = new ArrayList<>();
//    private List<Student> students = new ArrayList<>();

    private CourseOffering courseOffering;
    private Student student;
}

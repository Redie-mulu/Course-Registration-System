package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//Feven
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDto {

    private long id;
    private String code;
    private long capacity;
    private long availableSeats;
    private String initials;
    private List<AcademicBlock> block = new ArrayList<>();
    private Course course;
    private List<Faculty> staff = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    private CourseOffering courseOffering;
    private Student student;
}

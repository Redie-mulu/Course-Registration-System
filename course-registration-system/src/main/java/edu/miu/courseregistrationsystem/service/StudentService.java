package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.StudentDto;

import java.util.List;

public interface StudentService {
    public StudentDto registerStudent(StudentDto studentDto);
    public void dropStudent(String id);
    public StudentDto updateStudent(String id, StudentDto studentDto);
    public StudentDto getStudent(String id);
    public List<StudentDto> getAllStudents();

}

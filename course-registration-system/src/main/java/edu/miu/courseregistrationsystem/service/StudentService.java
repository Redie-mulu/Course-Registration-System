package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.StudentDto;

import java.util.List;

public interface StudentService {
    public StudentDto registerStudent(StudentDto studentDto);
    public void dropStudent(long id);
    public StudentDto updateStudent(long id, StudentDto studentDto);
    public StudentDto getStudent(long id);
    public List<StudentDto> getAllStudents();

}

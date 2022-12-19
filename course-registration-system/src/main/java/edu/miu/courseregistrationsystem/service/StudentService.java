package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;

import java.util.List;

//feven

public interface StudentService {
    public StudentDto registerStudent(StudentDto studentDto);
    public void dropStudent(long id);
    public StudentDto updateStudent(long id, StudentDto studentDto);
    public StudentDto getStudent(long id);
    public List<StudentDto> getAllStudents();
    public List<Student> findAll();
    public Student findOne(Long id);
    public Student update(Student student);
    public void delete(Long id);
    public Student add(Student t);

}

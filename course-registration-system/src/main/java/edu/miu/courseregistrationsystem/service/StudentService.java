package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;

import java.util.List;
/**
 * @author REDIET
 * @version 1.0
 *@created 16-Dec-2022 10:00:00 AM
 */
public interface StudentService {
    public StudentDto registerStudent(StudentDto studentDto);
    public void dropStudent(long id);
    public StudentDto updateStudent(long id, StudentDto studentDto);
    public StudentDto getStudent(long id);
    public List<StudentDto> getAllStudents();
    /**
     * @param students
     * admin can add students
     */
    public List<Student> addStudents(List<StudentDto> students);

}

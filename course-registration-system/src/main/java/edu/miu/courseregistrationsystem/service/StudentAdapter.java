package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter {
    public static Student getStudentFromStudentDto(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
//        student.setHomeAddress(AddressAdapter.getAddressFromAddressDto(studentDto.getHomeAddress()));
        return student;
    }

    public static StudentDto getStudentDtoFromStudent(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
//        studentDto.setHomeAddress(AddressAdapter.getAddressDtoFromAddress(student.getHomeAddress()));
        return studentDto;
    }
    public static List<StudentDto> getStudentDtosFromStudents(List<Student> students) {
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(getStudentDtoFromStudent(student));
        }
        return studentDtos;
    }
}

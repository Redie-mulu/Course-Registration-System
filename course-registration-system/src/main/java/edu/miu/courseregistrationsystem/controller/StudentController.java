package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStudents() {
        return "Hello World";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody StudentDto studentDto) {
        studentService.registerStudent(studentDto);
        return new ResponseEntity<>(studentDto, null, 200);
    }

}

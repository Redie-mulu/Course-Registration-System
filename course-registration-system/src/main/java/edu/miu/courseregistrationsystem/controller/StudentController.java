package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id) {
        StudentDto studentDto = studentService.getStudent(id);
        return new ResponseEntity<>(studentDto, null, 200);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(id, studentDto);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> dropStudent(@PathVariable long id) {
        studentService.dropStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

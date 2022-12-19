package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.service.imp.CourseOfferingImpl;
import edu.miu.courseregistrationsystem.service.imp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Feven

@RestController
@RequestMapping("/Registration")
public class RegistrationController {

    @Autowired
    private StudentServiceImp registerStudent;

    @Autowired
    private CourseOfferingImpl courseOffering;

    //Student in registration
    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> studentList = registerStudent.findAll();
        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new  ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getOne(@PathVariable long id){
        Student student= registerStudent.findOne(id);
        if(student==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody  Student student){
        Student updateStudent;
        Student tobeUpdateStudent=registerStudent.findOne(id);
        if(tobeUpdateStudent==null){
            updateStudent=registerStudent.add(student);
        }else{
            student.setId(tobeUpdateStudent.getId());
            updateStudent=registerStudent.update(student);
        }
        if(updateStudent==null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable long id){
        registerStudent.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student addedStudent= registerStudent.add(student);
        return ResponseEntity.ok(addedStudent);
    }
    //CourseOffering in Registration

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseOffering> getOneCourseOffering(@PathVariable long id){
        CourseOffering courses= courseOffering.findOne(id);
        if(courses==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courses);
    }
    @PutMapping("/courses/{id}")
    public ResponseEntity<CourseOffering> updateCourseOffering(@PathVariable long id, @RequestBody  CourseOffering courses){
        CourseOffering updatedCourse;
        CourseOffering tobeUpdateCourse=courseOffering.findOne(id);
        if(tobeUpdateCourse==null){
            updatedCourse=courseOffering.add(courses);
        }else{
            updatedCourse=courseOffering.update(courses);
        }
        if(updatedCourse==null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Object> deleteCourseOffering(@PathVariable long id){
        courseOffering.delete(id);
        return ResponseEntity.noContent().build();
    }

}



package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.CourseDto;
import edu.miu.courseregistrationsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public String getAllCourses() {
        return "course";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto) {
        courseService.createCourse(courseDto);
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable long id) {
        CourseDto courseDto = courseService.getCourse(id);
        return new ResponseEntity<CourseDto>(courseDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable long id, @RequestBody CourseDto courseDto) {
        courseService.updateCourse(id, courseDto);
        return new ResponseEntity<CourseDto>(courseDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> dropCourse(@PathVariable long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

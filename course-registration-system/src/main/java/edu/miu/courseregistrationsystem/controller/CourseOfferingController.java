package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseOffering")
public class CourseOfferingController {
    @Autowired
    private CourseOfferingService courseOfferingService;

    @GetMapping
    public String getAllCourseOfferings() {
        return "course offering";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourseOffering(@RequestBody CourseOfferingDto courseOfferingDto) {
        courseOfferingService.createCourseOffering(courseOfferingDto);
        return new ResponseEntity<>(courseOfferingDto,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseOffering(@PathVariable long id) {
        CourseOfferingDto courseOfferingDto = courseOfferingService.getCourseOffering(id);
        return new ResponseEntity<CourseOfferingDto>(courseOfferingDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourseOffering(@PathVariable long id, @RequestBody CourseOfferingDto courseOfferingDto) {
        courseOfferingService.updateCourseOffering(id, courseOfferingDto);
        return new ResponseEntity<CourseOfferingDto>(courseOfferingDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> dropCourseOffering(@PathVariable long id) {
        courseOfferingService.deleteCourseOffering(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

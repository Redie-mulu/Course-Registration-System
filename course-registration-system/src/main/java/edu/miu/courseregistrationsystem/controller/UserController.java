//package edu.miu.courseregistrationsystem.controller;
//
//import edu.miu.courseregistrationsystem.dto.AdminDto;
//import edu.miu.courseregistrationsystem.dto.StudentDto;
//import edu.miu.courseregistrationsystem.entity.Role;
//import edu.miu.courseregistrationsystem.entity.Student;
//import edu.miu.courseregistrationsystem.service.AdminService;
//import edu.miu.courseregistrationsystem.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class UserController {
//
//    @Autowired
//    private StudentService studentService;
//    @Autowired
//    private AdminService adminService;
////    @Autowired
////    private  FacultyService facultyService
//
//    @Autowired
//
//
//    @PostMapping("/signup/student")
//    public ResponseEntity<?> signupStudent(@RequestBody StudentDto studentDto){
//        studentDto.setRole(Role.STUDENT);
//        StudentDto student= studentService.registerStudent(studentDto);
//        return ResponseEntity.ok(student);
//    }
//
//
////    @PostMapping("/signup/faculty")
////    public ResponseEntity<?> signupFaculty(@RequestBody FacultyDTO facultyDTO){
////        facultyDTO.setRole(Role.FACULTY);
////        FacultyDto faculty= facultyService.save((facultyDTO));
////        return ResponseEntity.ok(faculty);
////    }
//
//
//    @PostMapping("/signup/admin")
//    public ResponseEntity<?> signupAdmin(@RequestBody AdminDto adminDTO){
//        adminDTO.setRole(Role.ADMIN);
//        AdminDto admin= adminService.save((adminDTO));
//        return ResponseEntity.ok(admin);
//    }
//    @GetMapping("/")
//    public String hello(){
//        return  "Welcome To Course Registration System";
//    }
//}

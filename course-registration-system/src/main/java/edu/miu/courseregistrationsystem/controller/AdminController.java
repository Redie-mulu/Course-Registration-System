package edu.miu.courseregistrationsystem.controller;


import edu.miu.courseregistrationsystem.repository.AdminRepository;
import edu.miu.courseregistrationsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @GetMapping("/all")
    public ResponseEntity<?> all(){

        return ResponseEntity.ok(adminService.allAdmin());
    }
}

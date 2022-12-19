package edu.miu.courseregistrationsystem.controller;


import edu.miu.courseregistrationsystem.dto.AdminDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.repository.AdminRepository;
import edu.miu.courseregistrationsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    @PostMapping("/createAdmin")
    public ResponseEntity<?> createAmin(@RequestBody AdminDto adminDto) {
         AdminDto adminDto1= adminService.save(adminDto);
        return new ResponseEntity<>(adminDto, null, 200);
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<?> addAmin(@RequestBody AdminDto adminDto) {
        adminService.save(adminDto);
        return new ResponseEntity<>(adminDto, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<?> all(){

        return ResponseEntity.ok(adminService.allAdmin());
    }
}

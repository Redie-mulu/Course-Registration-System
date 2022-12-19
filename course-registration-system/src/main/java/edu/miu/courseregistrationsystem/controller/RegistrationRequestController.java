package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.service.RegistrationRequestService;
import edu.miu.courseregistrationsystem.service.imp.RegistrationRequestServiceImp;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


/**
 * @author ruta
 * @version 1.0
 * @created 12-Sep-2020 10:00:00 AM
 */

@RestController
@RequestMapping("api/RegistrationRequests")
public class RegistrationRequestController {

    @Autowired
    RegistrationRequestService registrationRequestService;


    @GetMapping
    public String getAllregistrationRequests() {
        return "Hello World";
    }
    @PostMapping
    public ResponseEntity<?> addRegistrationRequest(@RequestBody RegistrationRequestDto registrationRequestDto) {
        registrationRequestService.addRegistrationRequest(registrationRequestDto);
        return new ResponseEntity<RegistrationRequestDto>(registrationRequestDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRegistrationRequest(@PathVariable long id) {
        RegistrationRequestDto registrationRequestDto = registrationRequestService.getRegistrationRequestById(id);
        return new ResponseEntity<RegistrationRequestDto>(registrationRequestDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegistrationRequest(@PathVariable long id, @RequestBody RegistrationRequestDto registrationRequestDto) {
        registrationRequestService.updateRegistrationRequest(id, registrationRequestDto);
        return new ResponseEntity<RegistrationRequestDto>(registrationRequestDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegistrationRequest(@PathVariable long id) {
        registrationRequestService.deleteRegistrationRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}




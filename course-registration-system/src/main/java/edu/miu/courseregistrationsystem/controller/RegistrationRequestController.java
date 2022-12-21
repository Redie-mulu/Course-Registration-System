package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/{studentId}/{eventId}/submitRegistrationRequests")
    public ResponseEntity<?> submitRegistrationRequests(@PathVariable long studentId, @RequestBody List<RegistrationRequestDto> registrationRequestDtos, @PathVariable long eventId) {
        registrationRequestService.submitRegistrationRequests(studentId,registrationRequestDtos,eventId);
        return new ResponseEntity<>(registrationRequestDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegistrationRequest(@PathVariable long id) {
        registrationRequestService.deleteRegistrationRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.service.imp.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration-request")
public class RegistrationRequestController {

    private RegistrationRequestService registrationRequestService;

    @PostMapping
    public ResponseEntity<?> addRegistrationRequest(@RequestBody RegistrationRequestDto registrationRequestDto) {
        RegistrationRequestDto responseDto = registrationRequestService.createRegistrationRequest(registrationRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllRegistrationRequest() {
        List<RegistrationRequestDto> responseList = registrationRequestService.getAllRegistrationRequest();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneRegistrationRequest(@PathVariable(value = "id") Long id) {
        RegistrationRequestDto responseDto = registrationRequestService.getOneRegistrationRequest(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<?> updateRegistrationRequest(@RequestBody RegistrationRequestDto registrationRequestDto) {
        return  null;
    }

    @DeleteMapping("/{id}")
    public void deleteRequestMapping(@PathVariable Long id) {
        registrationRequestService.deleteRegistrationRequest(id);
    }


    @Autowired
    public void setRegistrationRequestService(RegistrationRequestService registrationRequestService) {
        this.registrationRequestService = registrationRequestService;
    }
}

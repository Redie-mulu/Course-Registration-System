package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.service.imp.RegistrationRequestService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/registration-events/{eventId}/registration-requests")
public class RegistrationRequestController {

    private final RegistrationRequestService registrationRequestService;

    public RegistrationRequestController(RegistrationRequestService registrationRequestService) {
        this.registrationRequestService = registrationRequestService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void submitRegistrationRequests(@PathVariable Long eventId, @RequestBody List<RegistrationRequest> requests,
                                           Principal principal) {
        Student student = (Student) ((Authentication) principal).getPrincipal();
        registrationRequestService.submitRegistrationRequests(eventId, requests, student);
    }
}
``


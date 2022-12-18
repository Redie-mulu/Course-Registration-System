package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @version 1.0
 * @created 12-Sep-2020 10:00:00 AM
 */

@RestController
@RequestMapping("api/registration-events")
public class RegistrationEventController {
    @Autowired
    private RegistrationEventService registrationEventService;

    @GetMapping
    public ResponseEntity<?> getAllRegistrationEvents() {
        RegistrationEvents registrationEvents = new RegistrationEvents();
        List<RegistrationEventDto> registrationEvents2 = registrationEventService.getAllRegistrationEvents();
        registrationEvents.setRegistrationEvents(registrationEvents2);
        return new ResponseEntity<>(registrationEvents, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addRegistrationEvent(@RequestBody RegistrationEventDto registrationEventDto) {
        registrationEventService.addRegistrationEvent(registrationEventDto);
        return new ResponseEntity<RegistrationEventDto>(registrationEventDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRegistrationEvent(@PathVariable long id) {
        RegistrationEventDto registrationEventDto = registrationEventService.getRegistrationEvent(id);
        return new ResponseEntity<RegistrationEventDto>(registrationEventDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegistrationEvent(@PathVariable long id, @RequestBody RegistrationEventDto registrationEventDto) {
        registrationEventService.updateRegistrationEvent(id, registrationEventDto);
        return new ResponseEntity<RegistrationEventDto>(registrationEventDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegistrationEvent(@PathVariable long id) {
        registrationEventService.deleteRegistrationEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestRegistrationEvent() {
        List<RegistrationEventDto> registrationEventDto = registrationEventService.getLatestRegistrationEvent();
        return new ResponseEntity<List<RegistrationEventDto>>(registrationEventDto, HttpStatus.OK);
    }



}

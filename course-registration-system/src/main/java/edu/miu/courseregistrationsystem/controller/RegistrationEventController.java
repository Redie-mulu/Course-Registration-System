package edu.miu.courseregistrationsystem.controller;

import org.springframework.web.bind.annotation.PatchMapping;

public class RegistrationEventController {
    private final RegistrationEventService registrationEventService;

    public RegistrationEventController(RegistrationEventService registrationEventService) {
        this.registrationEventService = registrationEventService;
    }

    @PatchMapping("/{id}")
    public void processRegistrationEvent(@PathVariable Long id, @RequestParam("processed") boolean processed) {
        if (processed) {
            registrationEventService.processRegistrationEvent(id);
        }
    }
}

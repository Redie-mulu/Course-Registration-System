package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;

import java.util.List;

public class RegistrationEvents {
    List<RegistrationEventDto> registrationEvents;

    public RegistrationEvents() {
    }

    public RegistrationEvents(List<RegistrationEventDto> registrationEvents) {
        this.registrationEvents = registrationEvents;
    }

    public void setRegistrationEvents(List<RegistrationEventDto> registrationEvents) {
        this.registrationEvents = registrationEvents;
    }
}

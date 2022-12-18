package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;

import java.util.List;

public interface RegistrationEventService {
    public RegistrationEventDto addRegistrationEvent(RegistrationEventDto registrationEventDto);
    public RegistrationEventDto updateRegistrationEvent(long id,  RegistrationEventDto registrationEventDto);
    public void deleteRegistrationEvent(long id);
    public RegistrationEventDto getRegistrationEvent(long id);
    public List<RegistrationEventDto> getAllRegistrationEvents();

    public List<RegistrationEventDto>  getLatestRegistrationEvent();
}

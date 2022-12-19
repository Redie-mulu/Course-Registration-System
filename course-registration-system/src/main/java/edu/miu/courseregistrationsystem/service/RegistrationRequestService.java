package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;

import java.util.List;

public interface RegistrationRequestService  {

    public RegistrationRequestDto getRegistrationRequestById(long id);

    public List<RegistrationRequestDto> getAllRegistrationRequest();
    public RegistrationRequestDto createRegistrationRequest(RegistrationRequestDto registrationRequestDto);
    public RegistrationRequestDto  updateRegistrationRequest(long id,RegistrationRequestDto registrationRequestDto);
    public void deleteRegistrationRequest(long id);
    public RegistrationRequestDto addRegistrationRequest(RegistrationRequestDto registrationRequest);


    public void submitRegistrationRequests(long studentId, List<RegistrationRequestDto> registrationRequestDtos,long  eventId);


}

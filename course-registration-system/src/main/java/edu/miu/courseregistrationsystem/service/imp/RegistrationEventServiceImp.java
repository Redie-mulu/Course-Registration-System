package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.mapper.RegistrationEventMapper;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RegistrationEventServiceImp implements RegistrationEventService {
    @Autowired
    RegistrationEventRepository registrationEventRepository;
    private RegistrationEventMapper registrationEventMapper;

    @Override
    public RegistrationEventDto addRegistrationEvent(RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventMapper.getRegistrationEventFromRegistrationEventDto(registrationEventDto);
        registrationEventRepository.save(registrationEvent);
        return registrationEventDto;
    }

    @Override
    public RegistrationEventDto updateRegistrationEvent(long id, RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventMapper.getRegistrationEventFromRegistrationEventDto(registrationEventDto);
        registrationEventRepository.save(registrationEvent);
        return registrationEventDto;
    }

    @Override
    public void deleteRegistrationEvent(long id) {
        registrationEventRepository.deleteById(id);
    }

    @Override
    public RegistrationEventDto getRegistrationEvent(long id) {
        RegistrationEvent registrationEvent = registrationEventRepository.findById(id).get();
        RegistrationEventDto registrationEventDto = registrationEventMapper.getRegistrationEventDtoFromRegistrationEvent(registrationEvent);
        return registrationEventDto;
    }

    @Override
    public List<RegistrationEventDto> getAllRegistrationEvents() {
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        List<RegistrationEventDto> registrationEventDtos = registrationEventMapper.getRegistrationEventDtosFromRegistrationEvents(registrationEvents);
        return registrationEventDtos;
    }

    @Override
    public List<RegistrationEventDto> getLatestRegistrationEvent() {
            List<RegistrationEvent> registrationEvents =registrationEventRepository.findByStartDateLessThanAndEndDateGreaterThan(LocalDate.now());
            List<RegistrationEventDto> registrationEventDtos = registrationEventMapper.getRegistrationEventDtosFromRegistrationEvents(registrationEvents);
            return registrationEventDtos;
    }
}

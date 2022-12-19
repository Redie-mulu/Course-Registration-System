package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationEventStudentDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.mapper.RegistrationEventMapper;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationEventServiceImp implements RegistrationEventService {
    @Autowired
    RegistrationEventRepository registrationEventRepository;
//    @Autowired
//    private JmsTemplate jmsTemplate;
    @Autowired
    private RegistrationEventMapper registrationEventMapper;
    @Autowired
    private RegistrationGroupServiceImp registrationGroupServiceImp;

    @Override
    public RegistrationEventDto addRegistrationEvent(RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventMapper.registrationEventFromRegistrationEventDto(registrationEventDto);
        System.out.println(registrationEvent);
        registrationEventRepository.save(registrationEvent);
//        jmsTemplate.convertAndSend("registrationEventQueue", registrationEvent);
        return registrationEventDto;
    }

    @Override
    public RegistrationEventDto updateRegistrationEvent(long id, RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventMapper.registrationEventFromRegistrationEventDto(registrationEventDto);
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
        RegistrationEventDto registrationEventDto = registrationEventMapper.registrationEventDtoFromRegistrationEvent(registrationEvent);
        return registrationEventDto;
    }

    @Override
    public List<RegistrationEventDto> getAllRegistrationEvents() {
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        List<RegistrationEventDto> registrationEventDtos = registrationEventMapper.registrationEventDtosFromRegistrationEvents(registrationEvents);
        return registrationEventDtos;
    }

    @Override
    public List<RegistrationEventDto> getLatestRegistrationEvent() {
         List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
         List<RegistrationEvent> latestRegistrationEventTwo = new ArrayList<>();
    for(RegistrationEvent registrationEvent: registrationEvents){
        if(registrationEvent.getStartDate().isBefore(LocalDate.now()) && registrationEvent.getEndDate().isAfter(LocalDate.now())){
            latestRegistrationEventTwo.add(registrationEvent);
        }
    }
            return registrationEventMapper.registrationEventDtosFromRegistrationEvents(latestRegistrationEventTwo);
    }

    /**
     * @author REDIET
     * @param registrationEventId
     * @param registrationGroupId
     * admin can add registration group to registration event
     * admin will get existing registration group to existing registration event
     */
    @Override
    public void addRegistrationGroupToRegistrationEvent(long registrationEventId, long registrationGroupId) {
        RegistrationEvent registrationEvent = registrationEventRepository.findById(registrationEventId).get();
        registrationEvent.getRegistrationGroups().add(registrationGroupServiceImp.getRegistrationGroupById(registrationGroupId));
    }

    @Override
    public RegistrationEventStudentDto getRegistrationEventStudent(long studentId) {
        return null;
    }
}

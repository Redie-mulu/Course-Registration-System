package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationEventStudentDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupStudentDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.RegistrationGroup;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.mapper.RegistrationEventMapper;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegistrationEventServiceImp implements RegistrationEventService {
    @Autowired
    RegistrationEventRepository registrationEventRepository;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private RegistrationEventMapper registrationEventMapper;
    @Autowired
    private RegistrationGroupServiceImp registrationGroupServiceImp;

    @Override
    public RegistrationEventDto addRegistrationEvent(RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventMapper.registrationEventFromRegistrationEventDto(registrationEventDto);
        System.out.println(registrationEvent);
        registrationEventRepository.save(registrationEvent);
        RegistrationEventDto registrationEventStudentDto = registrationEventMapper.registrationEventDtoFromRegistrationEvent(registrationEvent);
        jmsTemplate.convertAndSend("registrationEventQueue", "registrationEvent");
        System.out.println("message sent");
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
        if(registrationEvent.getStartDate().isBefore(LocalDateTime.now()) && registrationEvent.getEndDate().isAfter(LocalDateTime.now())){
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
    /**
     * @author REDIET
     * student can see the list of registration events
     * student will get existing registration event to existing student
     */

    @Override
    public List<RegistrationEventStudentDto>  getRegistrationEventByStudentId(long studentId) {
        List<RegistrationEvent> registrationEvents =  registrationEventRepository.findByRegistrationGroupsStudentsId(studentId);
        /*List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        List<RegistrationEvent> registrationEventsForStudent = new ArrayList<>();
        for(RegistrationEvent registrationEvent: registrationEvents){
            for (RegistrationGroup registrationGroup: registrationEvent.getRegistrationGroups()){
                for (Student student: registrationGroup.getStudents()){
                    if(student.getId() == studentId){
                        registrationEventsForStudent.add(registrationEvent);
                    }
                }
            }
        }*/
        List<RegistrationEventStudentDto> registrationEventStudentDtos = new ArrayList<>();
        for(RegistrationEvent registrationEvent: registrationEvents){
            RegistrationEventStudentDto registrationEventStudentDto = new RegistrationEventStudentDto();
            registrationEventStudentDto.setId(registrationEvent.getId());
            registrationEventStudentDto.setStartDate(registrationEvent.getStartDate());
            registrationEventStudentDto.setEndDate(registrationEvent.getEndDate());
            registrationEventStudentDtos.add(registrationEventStudentDto);

        }
        return registrationEventStudentDtos;
    }

    /**
     * @author REDIET
     * send an email to student 8 and 4 hours before the registration event ends
     */
    /*@Override
    public void sendEmailReminder() {
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        for(RegistrationEvent registrationEvent: registrationEvents){
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(registrationEvent.getEndDate(), now);
            if(duration.toHours() == 4 || duration.toHours() == 8) {

                jmsTemplate.convertAndSend("OpenRegistrationEventQueue",
                        "Registration will be closed after" + duration.toHours() + " hours");

            }
        }
    }*/
}

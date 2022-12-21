package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.MapperUsingAdapter.RegistrationRequestMapper;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import edu.miu.courseregistrationsystem.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class RegistrationRequestServiceImp implements RegistrationRequestService {

    private RegistrationRequestMapper registrationRequestMapper;
    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public RegistrationRequestDto getRegistrationRequestById(long id) {
        RegistrationRequest registrationRequest= registrationRequestRepository.findById(id).get();
        RegistrationRequestDto registrationRequestDto  = registrationRequestMapper.getRegisrationRequestDtoFromRegistrationRequest(registrationRequest);
        return registrationRequestDto;
    }

    @Override
    public List<RegistrationRequestDto> getAllRegistrationRequest() {
        List<RegistrationRequestDto> registrationRequestDtos= registrationRequestRepository.findAll().
                stream().map(x-> registrationRequestMapper.getRegisrationRequestDtoFromRegistrationRequest(x)).
                collect(Collectors.toList());
        return  registrationRequestDtos;

    }

    @Override
    public RegistrationRequestDto createRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest registrationRequest = registrationRequestMapper.getRegisrationRequestFromRegistrationRequestDto(registrationRequestDto);
        registrationRequestRepository.save(registrationRequest);
        return registrationRequestDto;
    }

    @Override
    public RegistrationRequestDto updateRegistrationRequest(long id,RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest registrationRequest = registrationRequestMapper.getRegisrationRequestFromRegistrationRequestDto(registrationRequestDto);
        registrationRequestRepository.save(registrationRequest);
        return registrationRequestDto;
    }


    public void deleteRegistrationRequest(long id) {
        registrationRequestRepository.deleteById(id);

    }

    @Override
    public RegistrationRequestDto addRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest registrationRequest = registrationRequestMapper.getRegisrationRequestFromRegistrationRequestDto(registrationRequestDto);
        registrationRequestRepository.save(registrationRequest);
        return registrationRequestDto;
    }

    @Override
    public void submitRegistrationRequests(long studentId, List<RegistrationRequestDto> registrationRequestDtos,long  eventId) {
        Student student = studentRepository.findById(studentId).get();
//        RegistrationEvent event= registrationEventRepository.findById(id).get();
//        if(event.getStatus.equals("Open")){
//            for (RegistrationRequestDto r:registrationRequestDtos) {
//                addRegistrationRequest(r);}
//        }

    }
}

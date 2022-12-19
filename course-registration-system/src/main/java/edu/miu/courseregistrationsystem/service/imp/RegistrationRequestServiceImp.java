package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.Address;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.mapper.AddressMapper;
import edu.miu.courseregistrationsystem.mapper.RegistrationRequestMapper;
import edu.miu.courseregistrationsystem.repository.AddressRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import edu.miu.courseregistrationsystem.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationRequestServiceImp implements RegistrationRequestService {

    private RegistrationRequestMapper registrationRequestMapper;
    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private  RegistrationEventRepository registrationEventRepository;


    @Override
    public RegistrationRequestDto getRegistrationRequestById(long id) {
        RegistrationRequest registrationRequest= registrationRequestRepository.findById(id).get();
        RegistrationRequestDto registrationRequestDto  = registrationRequestMapper.getRegistrationRequestDtoFromRegistrationRequest(registrationRequest);
        return registrationRequestDto;
    }

    @Override
    public List<RegistrationRequestDto> getAllRegistrationRequest() {
      List<RegistrationRequestDto> registrationRequestDtos= registrationRequestRepository.findAll().
                                                                stream().map(x-> registrationRequestMapper.getRegistrationRequestDtoFromRegistrationRequest(x)).
                                                               collect(Collectors.toList());
      return  registrationRequestDtos;

    }

    @Override
    public RegistrationRequestDto createRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest registrationRequest = registrationRequestMapper.getRegistrationRequestFromRegistrationRequestDto(registrationRequestDto);
        registrationRequestRepository.save(registrationRequest);
        return registrationRequestDto;
    }

    @Override
    public RegistrationRequestDto updateRegistrationRequest(long id,RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest registrationRequest = registrationRequestMapper.getRegistrationRequestFromRegistrationRequestDto(registrationRequestDto);
       registrationRequestRepository.save(registrationRequest);
        return registrationRequestDto;
    }


    public void deleteRegistrationRequest(long id) {
        registrationRequestRepository.deleteById(id);

    }

    @Override
    public RegistrationRequestDto addRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest registrationRequest = registrationRequestMapper.getRegistrationRequestFromRegistrationRequestDto(registrationRequestDto);
        registrationRequestRepository.save(registrationRequest);
        return registrationRequestDto;
    }

    @Override
    public void submitRegistrationRequests(List<RegistrationRequestDto> registrationRequestDtos,long id) {
//        RegistrationEvent event= registrationEventRepository.findById(id).get();
//        if(event.getStatus.equals("Open")){
//            for (RegistrationRequestDto r:registrationRequestDtos) {
//                addRegistrationRequest(r);}
//        }

    }
}

package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.Address;
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

@Service
public class RegistrationRequestServiceImp implements RegistrationRequestService {

    private RegistrationRequestMapper registrationRequestMapper;
    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;


    @Override
    public RegistrationRequestDto getRegistrationRequestById(long id) {
        RegistrationRequest registrationRequest= registrationRequestRepository.findById((int) id).get();
        RegistrationRequestDto registrationRequestDto  = registrationRequestMapper.getRegistrationRequestDtoFromRegistrationRequest(registrationRequest);
        return registrationRequestDto;
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
        registrationRequestRepository.deleteById((int) id);

    }

    @Override
    public RegistrationRequestDto addRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest registrationRequest = registrationRequestMapper.getRegistrationRequestFromRegistrationRequestDto(registrationRequestDto);
        registrationRequestRepository.save(registrationRequest);
        return registrationRequestDto;
    }
}

package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
//import edu.miu.courseregistrationsystem.mapper.RegistrationRequestAdapter;
import edu.miu.courseregistrationsystem.exception.ApplicationException;
import edu.miu.courseregistrationsystem.mapper.RegistrationRequestMapper;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RegistrationRequestService {

    private RegistrationRequestRepository registrationRequestRepository;

    private RegistrationRequestMapper registrationRequestMapper;

    private RegistrationEventServiceImp registrationEventService;

    public RegistrationRequestDto createRegistrationRequest(RegistrationRequestDto registrationRequestDto) throws ApplicationException {
        List<RegistrationEventDto> registrationEventList = registrationEventService.getLatestRegistrationEvent();

        if(registrationEventList.size() == 0) {
            throw new ApplicationException("Registration period not opened or closed!");
        } else {
            //RegistrationEventDto registrationEvent = registrationEventList.get(0);
            RegistrationRequest request =
                    registrationRequestMapper.registrationRequestDtoToRegistrationRequest(registrationRequestDto);
            request.getCourseOffering().initial();

            RegistrationRequest response = registrationRequestRepository.save(request);
            return registrationRequestMapper
                    .registrationRequestToRegistrationRequestDto(registrationRequestRepository.save(request));
        }

//        RegistrationRequest request =
//                //RegistrationRequestAdapter.registrationRequestDtoToRegistrationRequest(registrationRequestDto);
//                registrationRequestMapper.registrationRequestDtoToRegistrationRequest(registrationRequestDto);
//        request.getCourseOffering().initial();
//
//        RegistrationRequest response = registrationRequestRepository.save(request);
//        //return RegistrationRequestAdapter
//        //        .registrationRequestToRegistrationRequestDto(registrationRequestRepository.save(request));
//        return registrationRequestMapper
//                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.save(request));
    }

    public List<RegistrationRequestDto> getAllRegistrationRequest() {
        List<RegistrationRequest> list = registrationRequestRepository.findAll();
        //return RegistrationRequestAdapter
        //        .registrationRequestsToRegistrationRequestDtos(list);
        return registrationRequestMapper.registrationRequestsToRegistrationRequestDtos(list);
    }

    public RegistrationRequestDto getOneRegistrationRequest(Long id) {
        //return RegistrationRequestAdapter
        //        .registrationRequestToRegistrationRequestDto(registrationRequestRepository.findById(id).get());
        return registrationRequestMapper
                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.findById(id).get());
    }

    public void deleteRegistrationRequest(Long id) {
        registrationRequestRepository.deleteById(id);
    }

    public RegistrationRequestDto updateRegistrationRequest(RegistrationRequestDto requestDto) {
        //RegistrationRequest request = RegistrationRequestAdapter.registrationRequestDtoToRegistrationRequest(requestDto);
        RegistrationRequest request = registrationRequestMapper.registrationRequestDtoToRegistrationRequest(requestDto);
        RegistrationRequest requestFromDb = registrationRequestRepository.findById(requestDto.getId()).get();

        requestFromDb.setStatus(request.getStatus());
        requestFromDb.setCourseOffering(request.getCourseOffering());
        requestFromDb.setPriority(request.getPriority());
        //requestFromDb.setId(requestDto.getId());

        //return RegistrationRequestAdapter
        //        .registrationRequestToRegistrationRequestDto(registrationRequestRepository.saveAndFlush(requestFromDb));
        return registrationRequestMapper
                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.saveAndFlush(requestFromDb));
    }


    @Autowired
    public void setRegistrationRequestRepository(RegistrationRequestRepository registrationRequestRepository) {
        this.registrationRequestRepository = registrationRequestRepository;
    }

    @Autowired
    public void setRegistrationRequestMapper(RegistrationRequestMapper registrationRequestMapper) {
        this.registrationRequestMapper = registrationRequestMapper;
    }

    @Autowired
    public void setRegistrationEventService(RegistrationEventServiceImp registrationEventService) {
        this.registrationEventService = registrationEventService;
    }
}

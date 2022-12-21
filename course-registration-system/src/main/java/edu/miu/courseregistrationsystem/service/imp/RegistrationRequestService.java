package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.mapper.RegistrationRequestAdapter;
import edu.miu.courseregistrationsystem.mapper.RegistrationRequestMapper;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RegistrationRequestService {

    private RegistrationRequestRepository registrationRequestRepository;

    private RegistrationRequestMapper registrationRequestMapper;

    public RegistrationRequestDto createRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest request =
                RegistrationRequestAdapter.registrationRequestDtoToRegistrationRequest(registrationRequestDto);
        request.getCourseOffering().initial();

        RegistrationRequest response = registrationRequestRepository.save(request);
        return RegistrationRequestAdapter
                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.save(request));
    }

    public List<RegistrationRequestDto> getAllRegistrationRequest() {
        List<RegistrationRequest> list = registrationRequestRepository.findAll();
        return RegistrationRequestAdapter
                .registrationRequestsToRegistrationRequestDtos(list);
    }

    public RegistrationRequestDto getOneRegistrationRequest(Long id) {
        return RegistrationRequestAdapter
                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.findById(id).get());
    }

    public void deleteRegistrationRequest(Long id) {
        registrationRequestRepository.deleteById(id);
    }

    public RegistrationRequestDto updateRegistrationRequest(RegistrationRequestDto requestDto) {
        RegistrationRequest request = RegistrationRequestAdapter.registrationRequestDtoToRegistrationRequest(requestDto);
        return RegistrationRequestAdapter
                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.saveAndFlush(request));
    }


    @Autowired
    public void setRegistrationRequestRepository(RegistrationRequestRepository registrationRequestRepository) {
        this.registrationRequestRepository = registrationRequestRepository;
    }

    @Autowired
    public void setRegistrationRequestMapper(RegistrationRequestMapper registrationRequestMapper) {
        this.registrationRequestMapper = registrationRequestMapper;
    }
}

package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.exception.ApplicationException;
import edu.miu.courseregistrationsystem.mapper.RegistrationRequestAdapter;
import edu.miu.courseregistrationsystem.mapper.RegistrationRequestMapper;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class RegistrationRequestService {

    private RegistrationRequestRepository registrationRequestRepository;

    private RegistrationRequestMapper registrationRequestMapper;

    private RegistrationEventServiceImp registrationEventService;
    @Autowired
    private StudentRepository studentRepository;

    public RegistrationRequestDto createRegistrationRequest(long studentId, RegistrationRequestDto registrationRequestDto) throws ApplicationException {
        List<RegistrationEventDto> registrationEventList = registrationEventService.getLatestRegistrationEvent();
        RegistrationEventDto registrationEventDto = registrationEventList.get(0);

        if((Objects.isNull(registrationEventDto))
                || (LocalDateTime.now().isBefore(registrationEventDto.getStartDate())
                || (LocalDateTime.now().isAfter(registrationEventDto.getEndDate())))){
            throw new ApplicationException("Registration period not opened or closed!");
        } else {
            RegistrationRequest request =
                    RegistrationRequestAdapter.registrationRequestDtoToRegistrationRequest(registrationRequestDto);
            request.getCourseOffering().initial();

            RegistrationRequest response = registrationRequestRepository.save(request);
            Student student = studentRepository.findById(studentId).get();
            student.addRegistrationRequest(response);
            studentRepository.save(student);

            return RegistrationRequestAdapter
                    .registrationRequestToRegistrationRequestDto(registrationRequestRepository.save(request));

        }
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

        RegistrationRequest requestFromDb = registrationRequestRepository.findById(requestDto.getId()).get();

        requestFromDb.setStatus(request.getStatus());
        requestFromDb.setCourseOffering(request.getCourseOffering());
        requestFromDb.setPriority(request.getPriority());
        requestFromDb.setId(requestDto.getId());

        return RegistrationRequestAdapter
                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.saveAndFlush(requestFromDb));
    }


    @Autowired
    public void setRegistrationRequestRepository(RegistrationRequestRepository registrationRequestRepository) {
        this.registrationRequestRepository = registrationRequestRepository;
    }

    @Autowired
    public void setRegistrationEventService(RegistrationEventServiceImp registrationEventService) {
        this.registrationEventService = registrationEventService;
    }

    @Autowired
    public void setRegistrationRequestMapper(RegistrationRequestMapper registrationRequestMapper) {
        this.registrationRequestMapper = registrationRequestMapper;
    }


}

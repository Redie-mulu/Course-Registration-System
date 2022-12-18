package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RegistrationRequestServiceImp {
    @Autowired
    private RegistrationRequestRepository registrationRequestRepository ;

    public RegistrationRequest create(RegistrationRequest registrationRequest) {
        return registrationRequestRepository.save(registrationRequest);
    }
    public Optional<RegistrationRequest> findById(int registrationRequestId) {
        return registrationRequestRepository.findById(registrationRequestId);
    }

    public RegistrationRequest update(int registrationRequestId, RegistrationRequest registrationRequest) {
        RegistrationRequest entity = findById(registrationRequestId).orElse(null);
        entity.setCourseCode(registrationRequest.getCourseCode());
        entity.setPriority(registrationRequest.getPriority());
        entity.setRegistration(registrationRequest.getRegistration());
        return registrationRequestRepository.save(entity);
    }
    public void deleteRegistrationRequest (Integer registrationRequestId) {
        registrationRequestRepository.deleteById(registrationRequestId);
    }

    public List<RegistrationRequest> findAll() {
        return registrationRequestRepository.findAll();
    }

    public void submitRegistrationRequests(Long eventId, List<RegistrationRequest> requests, Student student) {
        RegistrationEvent event = registrationEventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Registration event not found"));
        if (!event.isActive()) {
            throw new IllegalStateException("Cannot submit registration requests for inactive event");
        }
        Map<Long, List<RegistrationRequest>> requestsByBlockId = requests.stream()
                .collect(Collectors.groupingBy(RegistrationRequest::getBlockId));
        for (List<RegistrationRequest> blockRequests : requestsByBlockId.values()) {
            Set<Long> courseOfferingIds = blockRequests.stream().map(RegistrationRequest::getCourseOfferingId)
                    .collect(Collectors.toSet());
            if (courseOfferingIds.size() != blockRequests.size()) {
                throw new IllegalArgumentException("Duplicate course offerings not allowed");
            }
        }
        requests.forEach(r -> r.setStudent(student));

    }

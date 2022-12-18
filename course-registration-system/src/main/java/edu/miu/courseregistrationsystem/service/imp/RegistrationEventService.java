package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.repository.CourseOfferingRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import name.remal.gradleplugins.lombok.internal._relocated.name.remal.gradleplugins.toolkit.ResourceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegistrationEventService {

    private final RegistrationEventRepository registrationEventRepository;
    private final RegistrationRequestRepository registrationRequestRepository;
    private final RegistrationRepository registrationRepository;
    private final CourseOfferingRepository courseOfferingRepository;

    public RegistrationEventService(RegistrationEventRepository registrationEventRepository,
                                    RegistrationRequestRepository registrationRequestRepository,
                                    RegistrationRepository registrationRepository,
                                    CourseOfferingRepository courseOfferingRepository) {
        this.registrationEventRepository = registrationEventRepository;
        this.registrationRequestRepository = registrationRequestRepository;
        this.registrationRepository = registrationRepository;
        this.courseOfferingRepository = courseOfferingRepository;
    }

    public void processRegistrationEvent(Long id) {
        RegistrationEvent registrationEvent = registrationEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration event not found"));
        List<RegistrationRequest> registrationRequests = registrationRequestRepository.findByRegistrationEvent(registrationEvent);
        Map<Long, List<RegistrationRequest>> requestsByStudentId = registrationRequests.stream()
                .collect(Collectors.groupingBy(RegistrationRequest::getStudentId));
        for (List<RegistrationRequest> studentRequests : requestsByStudentId.values()) {
            Map<Long, RegistrationRequest> requestsByCourseOfferingId = studentRequests.stream()
                    .collect(Collectors.toMap(RegistrationRequest::getCourseOfferingId, Function.identity(),
                            (r1, r2) -> r1.getPriority() > r2.getPriority() ? r1 : r2));
            for (RegistrationRequest request : requestsByCourseOfferingId.values()) {
                CourseOffering courseOffering = request.getCourseOffering();
                if (courseOffering.getAvailableSe
}

package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.repository.CourseOfferingRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import name.remal.gradleplugins.lombok.internal._relocated.name.remal.gradleplugins.toolkit.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class RegistrationRequestService {

    private final RegistrationRequestRepository registrationRequestRepository;
    private final CourseOfferingRepository courseOfferingRepository;
    private final RegistrationEventRepository registrationEventRepository;

    public RegistrationRequestService(RegistrationRequestRepository registrationRequestRepository,
                                      CourseOfferingRepository courseOfferingRepository,
                                      RegistrationEventRepository registrationEventRepository) {
        this.registrationRequestRepository = registrationRequestRepository;
        this.courseOfferingRepository = courseOfferingRepository;
        this.registrationEventRepository = registrationEventRepository;
    }

    public void submitRegistrationRequests(List<RegistrationRequest> requests, Long eventId) {
        RegistrationEvent event = registrationEventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Registration event not found"));
        if (event.getStartDate().isAfter(Instant.now()) || event.getEndDate().isBefore(Instant.now())) {
            throw new InvalidRequestException("Registration event is not active");
        }
        Set<Long> courseOfferingIds = requests.stream()
                .map(RegistrationRequest::getCourseOfferingId)
                .collect(Collectors.toSet());
        List<CourseOffering> courseOfferings = courseOfferingRepository.findByIdIn(courseOfferingIds);
        Map<Long, CourseOffering> courseOfferingsById = courseOfferings.stream()
                .collect(Collectors.toMap(CourseOffering::getId, Function.identity()));
        for (RegistrationRequest request : requests) {
            CourseOffering courseOffering = courseOfferingsById.get(request.getCourseOfferingId());
            if (courseOffering == null)
                throw new InvalidRequestException("Invalid course offering ID: " + request.getCourseOfferingId());
            }
            if (request.getPriority() < 1 || request.getPriority() > courseOffering.getBlock().getCourseOfferings().size()) {
                throw new InvalidRequestException("Invalid priority: " + request.getPriority());
            }
            request.setCourseOffering(courseOffering);
            request.setRegistrationEvent(event);
        }
        registrationRequestRepository.saveAll(requests);
    }
}

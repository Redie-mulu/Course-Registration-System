package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.Course;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;

import java.util.ArrayList;
import java.util.List;

public class RegistrationRequestAdapter {

    public static RegistrationRequest registrationRequestDtoToRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest request = new RegistrationRequest();
        request.setStatus(registrationRequestDto.getStatus());
        request.setPriority(registrationRequestDto.getPriority());

        CourseOffering courseOffering = new CourseOffering();
        courseOffering.setCode(registrationRequestDto.getCourseOffering().getCode());
        courseOffering.setCapacity(registrationRequestDto.getCourseOffering().getCapacity());
        courseOffering.setAvailableSeats(registrationRequestDto.getCourseOffering().getAvailableSeats());
        courseOffering.setInitials(registrationRequestDto.getCourseOffering().getInitials());
        courseOffering.setStaff(registrationRequestDto.getCourseOffering().getStaff());
        //courseOffering.initial();
        Course course = new Course();
        course.setCode(registrationRequestDto.getCourseOffering().getCourse().getCode());
        course.setName(registrationRequestDto.getCourseOffering().getCourse().getName());
        course.setDescription(registrationRequestDto.getCourseOffering().getCourse().getDescription());
        course.setPreRequisite(registrationRequestDto.getCourseOffering().getCourse().getPreRequisite());

        courseOffering.setCourse(course);

        request.setCourseOffering(courseOffering);

        return request;
    }

    public static RegistrationRequestDto registrationRequestToRegistrationRequestDto(RegistrationRequest registrationRequest) {
        RegistrationRequestDto requestDto = new RegistrationRequestDto();
        requestDto.setId(registrationRequest.getId());
        requestDto.setStatus(registrationRequest.getStatus());
        requestDto.setPriority(registrationRequest.getPriority());

        CourseOfferingDto courseOfferingDto = new CourseOfferingDto();
        courseOfferingDto.setId(registrationRequest.getCourseOffering().getId());
        courseOfferingDto.setCode(registrationRequest.getCourseOffering().getCode());
        courseOfferingDto.setCapacity(registrationRequest.getCourseOffering().getCapacity());
        courseOfferingDto.setAvailableSeats(registrationRequest.getCourseOffering().getAvailableSeats());
        courseOfferingDto.setInitials(registrationRequest.getCourseOffering().getInitials());
        courseOfferingDto.setStaff(registrationRequest.getCourseOffering().getStaff());
        Course course = new Course();
        course.setId(registrationRequest.getCourseOffering().getCourse().getId());
        course.setCode(registrationRequest.getCourseOffering().getCourse().getCode());
        course.setName(registrationRequest.getCourseOffering().getCourse().getName());
        course.setDescription(registrationRequest.getCourseOffering().getCourse().getDescription());
        course.setPreRequisite(registrationRequest.getCourseOffering().getCourse().getPreRequisite());

        courseOfferingDto.setCourse(course);

        requestDto.setCourseOffering(courseOfferingDto);

        return requestDto;
    }

    public static List<RegistrationRequestDto> registrationRequestsToRegistrationRequestDtos(List<RegistrationRequest> lists) {
        List<RegistrationRequestDto> listToReturn = new ArrayList<>();

        for (RegistrationRequest request: lists) {
            RegistrationRequestDto requestDto =
                    RegistrationRequestAdapter.registrationRequestToRegistrationRequestDto(request);
            listToReturn.add(requestDto);
        }

        return listToReturn;
    }
}

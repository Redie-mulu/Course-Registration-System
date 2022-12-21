package edu.miu.courseregistrationsystem.MapperUsingAdapter;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;

public class RegistrationRequestMapper {
    public static RegistrationRequest getRegisrationRequestFromRegistrationRequestDto(RegistrationRequestDto registrationRequestDto){
         RegistrationRequest registrationRequest= new RegistrationRequest(registrationRequestDto.getId(),registrationRequestDto.getPriorityNumber(),registrationRequestDto.getCourseOffering());

         return  registrationRequest;

    }

    public static RegistrationRequestDto getRegisrationRequestDtoFromRegistrationRequest(RegistrationRequest registrationRequest){
        RegistrationRequestDto registrationRequestDto= new RegistrationRequestDto(registrationRequest.getId(),registrationRequest.getPriorityNumber(),registrationRequest.getCourseOffering());

        return  registrationRequestDto;

    }
}

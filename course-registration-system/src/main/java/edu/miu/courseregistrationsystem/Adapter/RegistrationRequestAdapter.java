//package edu.miu.courseregistrationsystem.Adapter;
//
//import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
//import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RegistrationRequestAdapter {
//
//    public static RegistrationRequest registrationRequestDtoToregistrationRequest(RegistrationRequestDto registrationRequestDto){
//        return  new RegistrationRequest(registrationRequestDto.getId(),registrationRequestDto.getPriorityNumber(),registrationRequestDto.getCourseOffering());
//    }
//
//    public static RegistrationRequestDto  registrationRequestToregistrationRequestDto(RegistrationRequest registrationRequest){
//        return  new RegistrationRequest(registrationRequest.getId(),registrationRequest.getPriorityNumber(),registrationRequest.getCourseOffering());
//    }
//
//    public static List<RegistrationRequestDto> registrationRequestsToregistrationRequestDtos(List<RegistrationRequest> registrationRequests){
//        List<RegistrationRequestDto> listRegistrationRequestDto=  new ArrayList<>();
//
//        for (RegistrationRequest r:registrationRequests) {
//            RegistrationRequestDto registrationRequestDto= registrationRequestToregistrationRequestDto(r);
//            listRegistrationRequestDto.add(registrationRequestDto);}
//        return  listRegistrationRequestDto;
//    }
//
//    public List<RegistrationRequest> registrationRequestDtosToregistrationRequests(List<RegistrationRequestDto> registrationRequestDtos);
//}

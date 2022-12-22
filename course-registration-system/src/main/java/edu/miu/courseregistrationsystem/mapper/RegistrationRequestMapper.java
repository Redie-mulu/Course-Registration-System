package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * * @author: Ruta
 * @author <a href="mailto:hermann.tipoh@gmail.com">Koffi Adolf Hermann Tipoh </a>
 * @version %I% %G%
 * @since 12/17/2022
 *
 * Interface to map RegistrationRequestDTo to RegistrationRequest and vice versa
 */
@Mapper
        (componentModel = "spring")
public interface RegistrationRequestMapper {
    public RegistrationRequest registrationRequestDtoToregistrationRequest(RegistrationRequestDto registrationRequestDto);

    public RegistrationRequestDto registrationRequestToregistrationRequestDto(RegistrationRequest registrationRequest);

    public List<RegistrationRequestDto> registrationRequestsToregistrationRequestDtos(List<RegistrationRequest> registrationRequests);

    public List<RegistrationRequest> registrationRequestDtosToregistrationRequests(List<RegistrationRequestDto> registrationRequestDtos);
}

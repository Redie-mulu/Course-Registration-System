package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 12:11 AM
 */

@Mapper(componentModel = "spring")
public interface RegistrationEventMapper {
    public RegistrationEvent getRegistrationEventFromRegistrationEventDto(RegistrationEventDto registrationEventDto);

    public RegistrationEventDto getRegistrationEventDtoFromRegistrationEvent(RegistrationEvent registrationEvent);
    public List<RegistrationEventDto> getRegistrationEventDtosFromRegistrationEvents(List<RegistrationEvent> registrationEvents);
    public List<RegistrationEvent> getRegistrationEventsFromRegistrationEventDtos(List<RegistrationEventDto> registrationEventDtos);
}

package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.RegistrationGroupDto;
import edu.miu.courseregistrationsystem.entity.RegistrationGroup;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 12:04 AM
 */
@Mapper(componentModel = "spring")

public interface RegistrationGroupMapper {

    public RegistrationGroup getRegistrationGroupFromRegistrationGroupDto(RegistrationGroupDto registrationGroupDto);
    public RegistrationGroupDto getRegistrationGroupDtoFromRegistrationGroup(RegistrationGroup registrationGroup);
    public List<RegistrationGroupDto> getRegistrationGroupDtosFromRegistrationGroups(List<RegistrationGroup> registrationGroups);
    public List<RegistrationGroup> getRegistrationGroupsFromRegistrationGroupDtos(List<RegistrationGroupDto> registrationGroupDtos);
}

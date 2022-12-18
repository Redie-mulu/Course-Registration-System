package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.RegistrationGroupDto;
import edu.miu.courseregistrationsystem.entity.RegistrationGroup;

import java.util.ArrayList;
import java.util.List;

public class RegistrationGroupMapper {
    private StudentMapper studentMapper;

    public RegistrationGroup getRegistrationGroupFromRegistrationGroupDto(RegistrationGroupDto registrationGroupDto) {
        RegistrationGroup registrationGroup = new RegistrationGroup();
        registrationGroup.setId(registrationGroupDto.getId());
        registrationGroup.setStudents(studentMapper.getStudentsFromStudentDtos(registrationGroupDto.getStudents()));
        return registrationGroup;
    }
    public RegistrationGroupDto getRegistrationGroupDtoFromRegistrationGroup(RegistrationGroup registrationGroup) {
        RegistrationGroupDto registrationGroupDto = new RegistrationGroupDto(registrationGroup.getId(),studentMapper.getStudentDtosFromStudents(registrationGroup.getStudents()),
        registrationGroup.getRegistrationEvent(), AcademicBlockMapper.getAcademicBlockDtosFromAcademicBlocks(registrationGroup.getAcademicBlocks()));
        return registrationGroupDto;
    }
    public List<RegistrationGroupDto> getRegistrationGroupDtosFromRegistrationGroups(List<RegistrationGroup> registrationGroups) {
        List<RegistrationGroupDto> registrationGroupDtos = new ArrayList<>();
        for (RegistrationGroup registrationGroup : registrationGroups) {
            registrationGroupDtos.add(getRegistrationGroupDtoFromRegistrationGroup(registrationGroup));
        }
        return registrationGroupDtos;
    }
    public List<RegistrationGroup> getRegistrationGroupsFromRegistrationGroupDtos(List<RegistrationGroupDto> registrationGroupDtos) {
        List<RegistrationGroup> registrationGroups = new ArrayList<>();
        for (RegistrationGroupDto registrationGroupDto : registrationGroupDtos) {
            registrationGroups.add(getRegistrationGroupFromRegistrationGroupDto(registrationGroupDto));
        }
        return registrationGroups;
    }
}

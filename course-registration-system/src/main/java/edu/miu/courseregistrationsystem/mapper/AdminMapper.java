package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.dto.AdminDto;
import edu.miu.courseregistrationsystem.entity.Address;
import edu.miu.courseregistrationsystem.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    public Admin getAdminFromAdminDto(AdminDto adminDto);

    public AdminDto getAdminDtoFromAdmin(Admin admin);
}

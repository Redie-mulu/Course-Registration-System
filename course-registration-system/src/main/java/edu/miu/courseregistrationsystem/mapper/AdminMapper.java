package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.AdminDto;
import edu.miu.courseregistrationsystem.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    public Admin adminToAdminDto(AdminDto adminDto);

    public AdminDto adminToAdminDto(Admin admin);
}

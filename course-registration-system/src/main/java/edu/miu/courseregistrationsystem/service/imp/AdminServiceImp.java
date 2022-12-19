package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AdminDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.Admin;
import edu.miu.courseregistrationsystem.mapper.AdminMapper;
import edu.miu.courseregistrationsystem.repository.AdminRepository;
import edu.miu.courseregistrationsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdminServiceImp implements AdminService {

    private AdminMapper adminMapper;
    @Autowired
    AdminRepository adminRepository;

    @Override
    public AdminDto save(AdminDto admin) {
        Admin a=  adminMapper.getAdminFromAdminDto(admin);
        adminRepository.save(a);
        return  admin;
    }

    @Override
    public List<AdminDto> allAdmin() {
        List<AdminDto> adminDtos= adminRepository.findAll().
                stream().map(x-> adminMapper.getAdminDtoFromAdmin(x)).
                collect(Collectors.toList());
        return  adminDtos;

    }
}

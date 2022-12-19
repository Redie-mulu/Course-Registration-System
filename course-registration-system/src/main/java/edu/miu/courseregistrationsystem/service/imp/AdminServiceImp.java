package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AdminDto;
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
    public AdminDto save(AdminDto adminDto) {
        Admin admin=  adminMapper.adminToAdminDto(adminDto);
        adminRepository.save(admin);
        return  adminDto;
    }

    @Override
    public List<AdminDto> allAdmin() {
        List<AdminDto> adminDtos= adminRepository.findAll().
                stream().map(x-> adminMapper.adminToAdminDto(x)).
                collect(Collectors.toList());
        return  adminDtos;

    }

    @Override
    public AdminDto getAdmin(long id) {

        Admin admin= adminRepository.findById(id).get();

        return adminMapper.adminToAdminDto(admin);

    }
}

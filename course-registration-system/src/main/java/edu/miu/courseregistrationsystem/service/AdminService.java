package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.AdminDto;
import edu.miu.courseregistrationsystem.entity.Admin;
import edu.miu.courseregistrationsystem.entity.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface AdminService {

    AdminDto save(AdminDto admin);
    List<AdminDto> allAdmin();

    AdminDto getAdmin(long id);
}

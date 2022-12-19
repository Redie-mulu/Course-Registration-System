package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.dto.AdminDto;
import edu.miu.courseregistrationsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    public AdminDto save(AdminDto admin);
}

package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Integer> {


}
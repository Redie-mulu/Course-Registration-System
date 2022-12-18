package edu.miu.courseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationEvent extends JpaRepository<RegistrationEvent, Long> {

}

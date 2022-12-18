package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationEventRepository extends JpaRepository<Long, RegistrationEvent> {
}

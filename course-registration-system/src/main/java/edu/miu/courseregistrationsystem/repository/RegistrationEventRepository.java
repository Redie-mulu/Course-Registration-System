package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Long> {
    List<RegistrationEvent> findByStartDateLessThanAndEndDateGreaterThan(LocalDate LocalDate);
}

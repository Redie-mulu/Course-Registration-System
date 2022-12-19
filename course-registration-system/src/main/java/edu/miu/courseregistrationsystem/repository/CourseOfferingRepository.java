package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long> {
}

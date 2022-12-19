package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicBlockRepository extends JpaRepository<AcademicBlock, Long> {
}

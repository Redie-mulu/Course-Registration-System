package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}

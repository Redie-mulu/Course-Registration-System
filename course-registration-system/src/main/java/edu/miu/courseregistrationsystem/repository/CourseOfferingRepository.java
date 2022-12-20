package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author feven
 * @version 1.0
 *@created 18-Dec-2022 3:10PM
 */
@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering,Long> {

}

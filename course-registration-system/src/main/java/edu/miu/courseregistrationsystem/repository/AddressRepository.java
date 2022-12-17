package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, String> {

}

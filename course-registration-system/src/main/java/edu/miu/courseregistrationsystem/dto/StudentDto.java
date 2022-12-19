package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Address;
import edu.miu.courseregistrationsystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    private long id;
    private String name;
    private String email;
    private Role role;
    private AddressDto mailingAddress;

    private AddressDto homeAddress;

}

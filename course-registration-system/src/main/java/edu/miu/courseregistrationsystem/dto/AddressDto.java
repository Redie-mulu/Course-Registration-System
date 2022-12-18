package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 09/12/2020 10:00 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {

    private long id;
    private String street;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String countryRegion;
    private List<StudentDto> students;

}

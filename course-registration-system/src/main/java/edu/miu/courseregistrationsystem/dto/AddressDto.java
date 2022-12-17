package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {


    private String id;
    private String street;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String countryRegion;
    @ManyToMany
    private List<StudentDto> students;

    @Override
    public String toString() {
        return "AddressDto{" +
                "id='" + id + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", countryRegion='" + countryRegion + '\'' +
                ", students=" + students +
                '}';
    }
}

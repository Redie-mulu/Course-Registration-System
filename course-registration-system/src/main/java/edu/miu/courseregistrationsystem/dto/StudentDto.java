package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Address;
import lombok.*;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StudentDto {
    private Long id;
    private String name;
    private String email;

    private Address mailingAddress;

    private Address homeAddress;

    @Data
    public static class Address {
        private long id;
        private String street;
        private String city;
        private String postalCode;
        private String stateProvince;
        private String countryRegion;
    }

}

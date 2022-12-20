package edu.miu.courseregistrationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentDto {
    private long id;
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

package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Address;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StudentDto {
    private long id;
    private String name;
    private String email;

    private AddressDto mailingAddress;

    private AddressDto homeAddress;

}

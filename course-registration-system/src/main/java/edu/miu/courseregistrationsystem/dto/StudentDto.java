package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Address;
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
    private String id;
    private String name;
    private String email;
    @ManyToOne
    private AddressDto mailingAddress;
    @ManyToOne
    private AddressDto homeAddress;

    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mailingAddress=" + mailingAddress +
                ", homeAddress=" + homeAddress +
                '}';
    }
}

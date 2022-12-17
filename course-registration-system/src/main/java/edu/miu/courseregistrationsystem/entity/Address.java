package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String countryRegion;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "mailingAddress")
    private List<Student> students;

    public Address(String street, String city, String postalCode, String stateProvince, String countryRegion) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.stateProvince = stateProvince;
        this.countryRegion = countryRegion;
    }
}


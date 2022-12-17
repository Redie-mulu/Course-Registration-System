package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String street;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String countryRegion;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;
}

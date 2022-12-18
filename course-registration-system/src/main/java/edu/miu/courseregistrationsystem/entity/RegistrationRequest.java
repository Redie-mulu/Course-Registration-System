package edu.miu.courseregistrationsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RegistrationRequest {
    @Id
    @GeneratedValue
    private long id;
    private int priorityNumber;

     @OneToMany
     @JoinColumn(name="registration_id")
    private List<CourseOffering> courseOffering;
     @ManyToOne
     private Student student ;



}

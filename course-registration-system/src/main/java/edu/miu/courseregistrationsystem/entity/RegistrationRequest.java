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

public class RegistrationRequest {
    @Id
    @GeneratedValue
    private long id;
    private int priorityNumber;

   // @ManyToOne
    //private CourseOffering courseOffering;


}

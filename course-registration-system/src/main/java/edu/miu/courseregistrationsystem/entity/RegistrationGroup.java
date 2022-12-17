package edu.miu.courseregistrationsystem.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class RegistrationGroup {

    @Id @GeneratedValue
    long id;
    @OneToMany
    private List<Student> students;

}

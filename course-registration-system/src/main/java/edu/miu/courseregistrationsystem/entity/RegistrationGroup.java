package edu.miu.courseregistrationsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class RegistrationGroup {

    @Id
    long id;
    @OneToMany
    private List<Student> students;
    @ManyToOne
    private RegistrationEvent registrationEvent;
}

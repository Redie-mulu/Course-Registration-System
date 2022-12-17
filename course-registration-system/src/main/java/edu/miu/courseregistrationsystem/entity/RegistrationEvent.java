package edu.miu.courseregistrationsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    List<RegistrationGroup> registrationGroups;
}

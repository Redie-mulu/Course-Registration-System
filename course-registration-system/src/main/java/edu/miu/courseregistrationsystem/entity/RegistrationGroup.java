package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationGroup {

    @Id @GeneratedValue
    long id;
    @OneToMany
    @JoinColumn
    private List<Student> students;
    @ManyToOne
    private RegistrationEvent registrationEvent;
    @OneToMany
    @JoinColumn(name = "block_id")
    private List<AcademicBlock> academicBlocks;
}

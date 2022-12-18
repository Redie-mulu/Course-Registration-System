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
    @Id
    long id;
    @OneToMany
    @JoinColumn
    private List<Student> students;
    @ManyToOne
    private RegistrationEvent registrationEvent;
    @OneToMany
    private List<AcademicBlock> academicBlocks;
}

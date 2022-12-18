package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 17-Dec-2022 5:00 PM
 */
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
    @OneToMany
    private List<AcademicBlock> academicBlocks;
}

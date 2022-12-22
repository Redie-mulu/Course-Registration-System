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

    @Id @GeneratedValue
    long id;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "registration_group_id")
    private List<Student> students;
    @OneToMany(cascade = CascadeType.ALL)
    private List<AcademicBlock> academicBlocks;
}

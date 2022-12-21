package edu.miu.courseregistrationsystem.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author REDIET
 * @version 1.0
 *@created 16-Dec-2022 9:00:00 AM
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;
    private String email;

}

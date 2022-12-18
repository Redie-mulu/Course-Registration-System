package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @author Rediet
 * @version 1.0
 * @created 17-Dec-2022 12:48 AM
 */
public class Faculty extends User{
    private String title;
}

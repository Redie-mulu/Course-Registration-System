package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Long capacity;
    private Long availableSeats;
    private String initials;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Course course;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "courseOffering_id")
    private Faculty faculty;


    public void initial(){
        String[] initial = new String[2];
        initial = faculty.getName().split(" ");

        char firstName = initial[0].charAt(0);
        char secondName = initial[1].charAt(0);

        this.initials = "" + firstName + secondName;
        this.code += "-" + this.initials;
    }
}

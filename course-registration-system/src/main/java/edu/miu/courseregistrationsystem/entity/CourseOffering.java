package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseOffering {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private long capacity;
    private long availableSeats;
    private String initials;
    @ManyToOne
    private Course course;
    @ManyToOne
    @JoinColumn(name = "courseOffering_id")
    private Faculty staff;



    public void initial(){
        String[] initial = new String[2];
        initial = staff.getName().split("");

        char firstname = initial[0].charAt(0);
        char lastname = initial[1].charAt(0);

        this.initials = ""+ firstname + lastname;
    }

    @Override
    public String toString() {
        return "CourseOffering{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", availableSeats=" + availableSeats +
                ", initials='" + initials + '\'' +
                ", course=" + course +
                ", staff=" + staff +
                '}';
    }
}

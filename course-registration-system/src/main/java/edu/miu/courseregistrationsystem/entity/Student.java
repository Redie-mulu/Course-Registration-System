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
public class Student extends User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;
    @ManyToOne
    @JoinColumn(name = "home_address_id")
    private Address homeAddress;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mailingAddress=" + mailingAddress +
//                ", homeAddress=" + homeAddress +
                '}';
    }

}

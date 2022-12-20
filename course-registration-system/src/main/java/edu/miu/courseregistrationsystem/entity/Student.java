package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author REDIET
 * @version 1.0
 *@created 16-Dec-2022 10:00:00 AM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;

    @ManyToOne(cascade = CascadeType.ALL)
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

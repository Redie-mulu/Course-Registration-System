package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
@SuperBuilder
public class Student extends User {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_address_id")
    private Address homeAddress;


}

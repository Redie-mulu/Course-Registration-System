package edu.miu.courseregistrationsystem.entity;

import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegistrationRequest {
    @Id
    @GeneratedValue
    private long id;
    private int priorityNumber;

    @ManyToOne
    private CourseOffering courseOffering;

    public RegistrationRequest(long id, int priorityNumber, RegistrationRequestDto.CourseOffering courseOffering) {
    }
}

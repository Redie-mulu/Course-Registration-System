package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RegistrationRequestDto {

    private long id;
    private int priorityNumber;
    private CourseOffering courseOffering;

    public RegistrationRequestDto(long id, int priorityNumber, edu.miu.courseregistrationsystem.entity.CourseOffering courseOffering) {
    }

    @Data
    public class CourseOffering {
        private long id;
        private String code;
        private long capacity;
        private long availableSeats;
        private String initials;
        private CourseDto courseDto;
        private List<FacultyDto> staff;
        private List<StudentDto> students;

    }
}

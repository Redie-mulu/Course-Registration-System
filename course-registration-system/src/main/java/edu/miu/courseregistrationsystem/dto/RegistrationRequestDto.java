package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.*;
import edu.miu.courseregistrationsystem.enumeration.RegistrationRequestStatus;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RegistrationRequestDto {

    private Long id;

    private Integer priority;

    private RegistrationRequestStatus status;

    private CourseOfferingDto courseOffering;

//    @Data
//    public static class CourseOffering {
//        private long id;
//        private String code;
//        private long capacity;
//        private long availableSeats;
//        private String initials;
//        private Course course;
//
//        private Faculty staff;
//    }
}

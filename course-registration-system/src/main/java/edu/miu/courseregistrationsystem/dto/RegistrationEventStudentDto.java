package edu.miu.courseregistrationsystem.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEventStudentDto {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    List<RegistrationGroupStudentDto> registrationGroups;
}

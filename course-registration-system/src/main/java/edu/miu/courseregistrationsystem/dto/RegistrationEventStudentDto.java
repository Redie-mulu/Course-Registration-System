package edu.miu.courseregistrationsystem.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class RegistrationEventStudentDto {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    List<RegistrationGroupStudentDto> registrationGroups;
}

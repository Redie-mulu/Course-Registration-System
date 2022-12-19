package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.RegistrationGroup;
import lombok.*;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class RegistrationEventDto {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    List<RegistrationGroupDto> registrationGroups;
}

package edu.miu.courseregistrationsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private LocalDate startDate;
    @JsonIgnore
    private LocalDate endDate;
    List<RegistrationGroupDto> registrationGroups;
}

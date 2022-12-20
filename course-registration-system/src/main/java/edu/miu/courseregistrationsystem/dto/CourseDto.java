package edu.miu.courseregistrationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CourseDto {
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<CourseOfferingDto> courseOffering;

}

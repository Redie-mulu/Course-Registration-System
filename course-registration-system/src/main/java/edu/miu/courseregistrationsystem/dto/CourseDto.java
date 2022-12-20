package edu.miu.courseregistrationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<CourseOfferingDto> courseOffering;

}

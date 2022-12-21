package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Course;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDto {
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<Course> preRequisite;

}

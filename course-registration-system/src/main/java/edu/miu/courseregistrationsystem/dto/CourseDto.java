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
    private long id;
    private String code;
    private String name;
    private String description;
    //TODO: Course and prerequisite are many to many
    private List<CourseDto> preRequisite;

}

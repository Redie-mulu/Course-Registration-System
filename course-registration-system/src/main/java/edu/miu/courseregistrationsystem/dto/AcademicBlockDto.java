package edu.miu.courseregistrationsystem.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class AcademicBlockDto {
    private long id;
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;


}

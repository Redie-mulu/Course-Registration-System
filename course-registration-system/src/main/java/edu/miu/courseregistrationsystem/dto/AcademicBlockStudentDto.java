package edu.miu.courseregistrationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Rediet
 * @version 1.0
 * @created 19/12/2020 10:51 PM
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademicBlockStudentDto {

    private long id;
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;
}

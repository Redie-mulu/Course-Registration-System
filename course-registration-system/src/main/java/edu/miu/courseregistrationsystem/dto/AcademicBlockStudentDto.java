package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 19/12/2020 10:51 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AcademicBlockStudentDto {

    private long id;
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<CourseOfferingDto> courseOfferings;
}

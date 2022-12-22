package edu.miu.courseregistrationsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademicBlockDto {
    private long id;
    private String code;
    private String name;
    private String semester;
    @JsonIgnore
    private LocalDate startDate;
    @JsonIgnore
    private LocalDate endDate;
//    private List<CourseOfferingDto> courseOfferings;

}

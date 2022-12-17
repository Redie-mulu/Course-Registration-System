package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
public class AcademicBlockDTO {
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<CourseOffering> courseOffering = new ArrayList<>();

    public AcademicBlockDTO() {
    }

    public AcademicBlockDTO(String code, String name, String semester,
                         LocalDate startDate, LocalDate endDate, List<CourseOffering> courseOffering) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseOffering = courseOffering;
    }

}

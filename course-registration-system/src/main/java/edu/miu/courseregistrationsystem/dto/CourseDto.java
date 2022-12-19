package edu.miu.courseregistrationsystem.dto;

import lombok.Data;
import java.util.List;
@Data
public class CourseDto {
    private long id;
    private String code;
    private String name;
   private String description;
   private List<CourseDto> preRequisite;

}

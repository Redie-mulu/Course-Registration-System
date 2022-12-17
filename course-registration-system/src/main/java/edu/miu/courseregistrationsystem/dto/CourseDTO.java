package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.Course;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDTO {
    private String code;
    private String name;
    private String description;
    private List<Course> preRequisite = new ArrayList<>();

    public CourseDTO() {
    }

    public CourseDTO(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }
}

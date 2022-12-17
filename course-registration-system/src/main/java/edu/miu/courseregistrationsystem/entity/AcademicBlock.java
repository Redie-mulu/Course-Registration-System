package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicBlock {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToMany(mappedBy = "block", cascade = CascadeType.ALL)
    private List<CourseOffering> courseOffering = new ArrayList<>();


    public void addCourseOffering(CourseOffering courseOffering){
        this.courseOffering.add(courseOffering);
    }

    @Override
    public String toString() {
        return "AcademicBlock{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", semester='" + semester + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseOffering=" + courseOffering +
                '}';
    }
}

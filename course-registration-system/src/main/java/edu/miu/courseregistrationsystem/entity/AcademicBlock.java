package edu.miu.courseregistrationsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
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


    public AcademicBlock() {
    }

    public AcademicBlock(String code, String name, String semester,
                         LocalDate startDate, LocalDate endDate, List<CourseOffering> courseOffering) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseOffering = courseOffering;
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

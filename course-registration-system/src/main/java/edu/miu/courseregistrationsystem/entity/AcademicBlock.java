package edu.miu.courseregistrationsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<CourseOffering> getCourseOffering() {
        return courseOffering;
    }

    public void setCourseOffering(List<CourseOffering> courseOffering) {
        this.courseOffering = courseOffering;
    }
}

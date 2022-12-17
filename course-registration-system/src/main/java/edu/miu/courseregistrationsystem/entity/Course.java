package edu.miu.courseregistrationsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "prerequisite_id")
    private List<Course> preRequisite = new ArrayList<>();

    public Course() {
    }

    public Course(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public void addPreRequisite(Course course){
        preRequisite.add(course);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", preRequisite=" + preRequisite +
                '}';
    }
}

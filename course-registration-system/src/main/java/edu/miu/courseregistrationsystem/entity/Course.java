package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "preRequisite_id")
    private List<Course> preRequisite = new ArrayList<>();

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

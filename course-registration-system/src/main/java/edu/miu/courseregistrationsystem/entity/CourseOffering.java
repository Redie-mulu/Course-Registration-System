package edu.miu.courseregistrationsystem.entity;

import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class CourseOffering {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private long capacity;
    private long availableSeats;
    @ElementCollection
    private List<String> facultyInitial;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Bloc_CourseOffering",
    joinColumns = {@JoinColumn(name = "courseOffering_id")},
    inverseJoinColumns = {@JoinColumn(name = "academicBlock_id")})
    private List<AcademicBlock> block = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Course course;
    @OneToMany
    @JoinColumn(name = "courseOffering_id")
    private List<Faculty> faculties = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "Registration")
    private List<Student> students = new ArrayList<>();


    public CourseOffering() {
    }

    public CourseOffering(String code, Course course, long capacity, long availableSeats,
                          List<AcademicBlock> block, String facultyInitial) {
        this.code = code;
        this.course = course;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.block = block;
        this.facultyInitial = facultyInitial;
    }
    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }
    public void addInitials(){
        foreach(Faculty staff : faculties){
            String name= staff.getName();
            List<String> names= name.split(" ");
            char first= names.get(0).charAt(0);
            char last= names.get(1).charAt(0);

            String intials="" + first +last;

            facultyInitial.add(intials);


        }
    }
    public long availableSeats(){
        return this.capacity - students.size();
    }


    @Override
    public String toString() {
        return "CourseOffering{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", availableSeats=" + availableSeats +
                ", facultyInitial='" + facultyInitial + '\'' +
                ", block=" + block +
                ", course=" + course +
                ", faculty=" + faculty +
                ", students=" + students +
                '}';
    }
}

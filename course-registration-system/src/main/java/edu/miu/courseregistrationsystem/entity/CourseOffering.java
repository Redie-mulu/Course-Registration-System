package edu.miu.courseregistrationsystem.entity;

import edu.miu.courseregistrationsystem.entity.AcademicBlock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CourseOffering {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private long capacity;
    private long availableSeats;
    private String facultyInitial;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Bloc_CourseOffering",
    joinColumns = {@JoinColumn(name = "courseOffering_id")},
    inverseJoinColumns = {@JoinColumn(name = "academicBlock_id")})
    private List<AcademicBlock> block = new ArrayList<>();
    @ManyToOne
    private Course course;


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
    public long availableSeats(long numberOfStudents){
        return this.capacity - numberOfStudents;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(long availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<AcademicBlock> getBlock() {
        return block;
    }

    public void setBlock(List<AcademicBlock> block) {
        this.block = block;
    }

    public String getFacultyInitial() {
        return facultyInitial;
    }

    public void setFacultyInitial(String facultyInitial) {
        this.facultyInitial = facultyInitial;
    }
}

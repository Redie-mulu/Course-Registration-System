package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseOffering {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private long capacity;
    private long availableSeats;
    private String initials;
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "Bloc_CourseOffering",
//    joinColumns = {@JoinColumn(name = "courseOffering_id")},
//    inverseJoinColumns = {@JoinColumn(name = "academicBlock_id")})
//    private List<AcademicBlock> block = new ArrayList<>();
    @ManyToOne
    private Course course;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseOffering_id")
    private List<Faculty> staff ;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Registration")
    private List<Student> students ;


    public long availableSeats(){
        return this.capacity - students.size();
    }
//    public void addAcademicBlock(AcademicBlock block){
//        this.block.add(block);
//    }
    public void addFaculty(Faculty faculty){
        staff.add(faculty);
    }

    // Todo
    public void initial(){

    }

    @Override
    public String toString() {
        return "CourseOffering{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", availableSeats=" + availableSeats +
                ", initials='" + initials + '\'' +
//                ", block=" + block +
                ", course=" + course +
                ", staff=" + staff +
                ", students=" + students +
                '}';
    }
}

package edu.miu.courseregistrationsystem.entity;

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
    private String initials;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Block_id")
    private List<AcademicBlock> block = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Course course;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "courseOffering_id")
    private List<Faculty> staff = new ArrayList<>();
   @Transient
    private List<RegistrationRequest> registrationRequests;


    public long availableSeats(){
        return this.capacity - registrationRequests.size();
    }
    public void addAcademicBlock(AcademicBlock block){
        this.block.add(block);
    }
    public void addFaculty(Faculty faculty){
        staff.add(faculty);
    }

    public void initial(){
        String[] initial = new String[2];
        for(Faculty names: staff){
            initial = names.getName().split("");
        }
        char firstName = initial[0].charAt(0);
        char secondName = initial[1].charAt(1);

        this.initials = "" + firstName + secondName;
    }


    @Override
    public String toString() {
        return "CourseOffering{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", availableSeats=" + availableSeats +
                ", initials='" + initials + '\'' +
                ", block=" + block +
                ", course=" + course +
                ", staff=" + staff +
                '}';
    }
}

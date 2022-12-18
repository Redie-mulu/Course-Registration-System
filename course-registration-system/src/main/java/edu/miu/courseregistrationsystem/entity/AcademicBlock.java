package edu.miu.courseregistrationsystem.entity;

import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * @author REDIET
 * @version 1.0
 * @created 08-Sep-2020 10:00:00 AM
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    /**
     * The name of the academic block
     */
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CourseOffering> courseOfferings = new ArrayList<>();


    public void addCourseOffering(CourseOffering courseOffering){
        this.courseOfferings.add(courseOffering);
    }
}

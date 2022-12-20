package edu.miu.courseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feven
 * @version 1.0
 *@created 16-Dec-2022 10:00:00 AM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Registration {

    List<CourseOffering> courseOfferings = new ArrayList<>();
}

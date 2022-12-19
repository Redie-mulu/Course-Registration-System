package edu.miu.courseregistrationsystem.dto;

import edu.miu.courseregistrationsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto  {
    private long id;
    private String name;
    private String email;
}

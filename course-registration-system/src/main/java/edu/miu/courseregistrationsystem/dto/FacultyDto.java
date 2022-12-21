package edu.miu.courseregistrationsystem.dto;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private long id;
    private String name;
    private String email;
    private String title;
}

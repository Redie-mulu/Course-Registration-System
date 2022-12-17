package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.StudentDto;


import java.util.ArrayList;
import java.util.List;

public class Students {
    List<StudentDto> students = new ArrayList<>();

    public Students(List<StudentDto> students) {
        this.students = students;
    }

    public List<StudentDto> getStudents() {
        return students;
    }
}

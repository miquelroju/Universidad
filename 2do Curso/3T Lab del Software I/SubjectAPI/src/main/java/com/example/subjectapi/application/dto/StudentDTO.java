package com.example.subjectapi.application.dto;

import com.example.subjectapi.domain.Student;
import com.example.subjectapi.domain.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StudentDTO {


    private String id;

    private String name;

    private double grade;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.grade = student.getGrade();
    }
}

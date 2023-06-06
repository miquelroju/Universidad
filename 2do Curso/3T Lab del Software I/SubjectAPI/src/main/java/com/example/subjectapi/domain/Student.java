package com.example.subjectapi.domain;

import com.example.subjectapi.application.dto.StudentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity(name = "students")
public class Student {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private double grade;

    @ManyToOne
    private Subject subject;

    public Student(StudentDTO studentDTO, Subject subject) {
        this.name = studentDTO.getName();
        this.grade = studentDTO.getGrade();
        this.subject = subject;
    }
}

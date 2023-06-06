package com.example.subjectapi.domain;

import com.example.subjectapi.application.dto.SubjectDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
public class Subject {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    @OneToMany(mappedBy = "subject")
    private List<Student> students = new ArrayList<>();

    public Subject(SubjectDTO subjectDTO) {
        this.name = subjectDTO.getName();
    }


    public void addStudent(Student student) {
        students.add(student);
    }
}

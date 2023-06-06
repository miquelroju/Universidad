package com.example.subjectapi.application.dto;

import com.example.subjectapi.domain.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class SubjectDTO {


    private String id;

    private String name;

    public SubjectDTO(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
    }
}

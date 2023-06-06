package com.example.subjectapi.api;


import com.example.subjectapi.application.SubjectController;
import com.example.subjectapi.application.dto.SubjectDTO;
import com.example.subjectapi.domain.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectRestController {

    private SubjectController subjectController;

    public SubjectRestController(SubjectController subjectController) {
        this.subjectController = subjectController;
    }

    @PostMapping("/subjects")
    public SubjectDTO createSubject(@RequestBody SubjectDTO subject) {
        return subjectController.createSubject(subject);
    }
}

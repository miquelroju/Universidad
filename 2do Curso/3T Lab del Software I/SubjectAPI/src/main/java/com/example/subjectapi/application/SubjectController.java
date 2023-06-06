package com.example.subjectapi.application;

import com.example.subjectapi.application.dto.SubjectDTO;
import com.example.subjectapi.domain.Subject;
import com.example.subjectapi.persistence.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SubjectController {

    private SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject(subjectDTO);
        subjectRepository.save(subject);
        return new SubjectDTO(subject);
    }
}

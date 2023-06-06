package com.example.subjectapi.application;

import com.example.subjectapi.application.dto.StudentDTO;
import com.example.subjectapi.application.dto.SubjectDTO;
import com.example.subjectapi.domain.Student;
import com.example.subjectapi.domain.Subject;
import com.example.subjectapi.persistence.StudentRepository;
import com.example.subjectapi.persistence.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    private SubjectRepository subjectRepository;
    private StudentRepository studentRepository;

    public StudentController(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public StudentDTO createStudent(String subjectId, StudentDTO studentDTO) {
        Subject subject = subjectRepository.findById(subjectId).get();

        Student student = new Student(studentDTO, subject);
        subject.addStudent(student);

        studentRepository.save(student);
        subjectRepository.save(subject);

        return new StudentDTO(student);
    }

}

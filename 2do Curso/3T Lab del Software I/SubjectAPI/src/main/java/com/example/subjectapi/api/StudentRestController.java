package com.example.subjectapi.api;


import com.example.subjectapi.application.StudentController;
import com.example.subjectapi.application.SubjectController;
import com.example.subjectapi.application.dto.StudentDTO;
import com.example.subjectapi.application.dto.SubjectDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

    private StudentController studentController;

    public StudentRestController(StudentController studentController) {
        this.studentController = studentController;
    }

    @PostMapping("/subjects/{subjectId}/students")
    public StudentDTO createStudent(@PathVariable String subjectId, @RequestBody StudentDTO studentDTO) {
        return studentController.createStudent(subjectId, studentDTO);
    }
}

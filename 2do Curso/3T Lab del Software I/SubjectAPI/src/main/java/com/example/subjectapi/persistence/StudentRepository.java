package com.example.subjectapi.persistence;

import com.example.subjectapi.domain.Student;
import com.example.subjectapi.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}

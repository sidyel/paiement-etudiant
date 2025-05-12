package com.example.demopaymant.repository;

import com.example.demopaymant.entite.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {

    Student findStudentByCode(String code);
    List<Student> findStudentByProgrammeId(String programmeId);

}

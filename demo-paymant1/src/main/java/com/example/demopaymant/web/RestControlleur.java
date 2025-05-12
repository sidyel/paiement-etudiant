package com.example.demopaymant.web;

import com.example.demopaymant.entite.Paymant;
import com.example.demopaymant.entite.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demopaymant.repository.PaymentRepository;
import com.example.demopaymant.repository.StudentRepository;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
public class RestControlleur {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping(path = "/payments")
    public List<Paymant> getPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/paymentid/{id}")
    public Paymant getPayment(@PathVariable Long id) {
        return paymentRepository.findById(id).get(); }

    @GetMapping(path = "/payments/{code}")
    public List<Paymant> getPaymentscode(@PathVariable String code) {
        return paymentRepository.findByEtudiant_Code(code);
    }

    @GetMapping(path = "/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/studentcode/{code}")
    public Student getStudentcode(@PathVariable String code) {
        return studentRepository.findStudentByCode(code);
    }

    @GetMapping(path = "/studentprogramme/{programme}")
    public List<Student> getStudentprogramme(@PathVariable String programme) {
        return studentRepository.findStudentByProgrammeId(programme);
    }

    @PostMapping(path = "/student")
    public Student addStudent(@RequestBody Student student) {
        if(student.getId() == null) {
            student.setId(UUID.randomUUID().toString());
        }
        return studentRepository.save(student);
    }
    @PostMapping(path = "/paymant")
    public Paymant addPaymant(@RequestParam String code,@RequestBody Paymant paymant) {
        Student student=studentRepository.findStudentByCode(code);
        paymant.setEtudiant(student);
        return paymentRepository.save(paymant);
    }

    @PutMapping(path = "/modifierStudent/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        Student stud = studentRepository.findById(id).get();

        if(student.getNom()!=null) stud.setNom(student.getNom());
        if(student.getPrenom()!=null) stud.setPrenom(student.getPrenom());
        if(student.getCode()!=null) stud.setCode(student.getCode());
        if(student.getPhoto()!=null) stud.setPhoto(student.getPhoto());
        if(student.getPrgrammeId()!=null) stud.setPrgrammeId(student.getPrgrammeId());


        return studentRepository.save(stud);
    }

    @DeleteMapping(path = "/deletestudent/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentRepository.deleteById(id);
    }


}

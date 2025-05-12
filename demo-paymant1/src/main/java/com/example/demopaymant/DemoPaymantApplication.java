package com.example.demopaymant;

import com.example.demopaymant.entite.Paymant;
import com.example.demopaymant.entite.PaymentType;
import com.example.demopaymant.entite.Statue_payment;
import com.example.demopaymant.entite.Student;
import com.example.demopaymant.repository.PaymentRepository;
import com.example.demopaymant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class DemoPaymantApplication {

    public static void main(String[] args) {
        // Lancement de l'application Spring
        ConfigurableApplicationContext context = SpringApplication.run(DemoPaymantApplication.class, args);

        // Récupération du bean StudentRepository depuis le contexte
        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        PaymentRepository paymentRepository=context.getBean(PaymentRepository.class);
        Student student=new Student(UUID.randomUUID().toString(),"ass","dione","111a","math",null);
        studentRepository.save(student);
        studentRepository.save(new Student(UUID.randomUUID().toString(),"sidy","fall","111b","math",null));
        studentRepository.save(new Student(UUID.randomUUID().toString(),"modou","diop","111c","math",null));

        Statue_payment statue_payment=Statue_payment.cree;
        PaymentType paymentType=PaymentType.cheque;

        paymentRepository.save(new Paymant(LocalDate.now(),20000,PaymentType.depot,Statue_payment.rejete,"jjj",student));
        paymentRepository.save(new Paymant(LocalDate.now(),50000,PaymentType.cash,Statue_payment.valide,"kk,",student));
        paymentRepository.save(new Paymant(LocalDate.now(),10000,PaymentType.cheque,Statue_payment.cree,"jn",student));



        System.out.println("Nombre d'étudiants en base : ");
    }
}

package com.example.demopaymant.entite;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Paymant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double montant;
    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Enumerated(EnumType.STRING)
    private Statue_payment status;

    private String file;
    @ManyToOne
    private Student etudiant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public Statue_payment getStatus() {
        return status;
    }

    public void setStatus(Statue_payment status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Student getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Student etudiant) {
        this.etudiant = etudiant;
    }

    public Paymant( LocalDate date, double montant, PaymentType type, Statue_payment status, String file, Student etudiant) {

        this.date = date;
        this.montant = montant;
        this.type = type;
        this.status = status;
        this.file = file;
        this.etudiant = etudiant;
    }

    public Paymant() {
    }



}

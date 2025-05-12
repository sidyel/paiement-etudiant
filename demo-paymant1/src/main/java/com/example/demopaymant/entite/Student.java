package com.example.demopaymant.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private String id;
    private String nom;
    private String prenom;

    @Column(unique=true)
    private String code;
    private  String programmeId;
    private String photo;

    public Student(String id, String nom, String prenom, String code, String prgrammeId, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.code = code;
        this.programmeId = prgrammeId;
        this.photo = photo;
    }

    public Student() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrgrammeId(String prgrammeId) {
        this.programmeId = prgrammeId;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCode() {
        return code;
    }

    public String getPrgrammeId() {
        return programmeId;
    }

    public String getPhoto() {
        return photo;
    }


}

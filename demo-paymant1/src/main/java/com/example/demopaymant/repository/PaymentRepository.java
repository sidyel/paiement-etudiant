package com.example.demopaymant.repository;

import com.example.demopaymant.entite.Paymant;
import com.example.demopaymant.entite.PaymentType;
import com.example.demopaymant.entite.Statue_payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Paymant,Long>{

    List<Paymant> findByType(PaymentType type);
    List<Paymant> findByStatus(Statue_payment status);

    List<Paymant> findByEtudiant_Code(String etudiantCode);
}

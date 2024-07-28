package com.example.demo.repository;

import com.example.demo.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

    List<Evenement> findAllByDateEvenementOrCategorieOrLieu(LocalDate date,String categorie,String lieu);

}
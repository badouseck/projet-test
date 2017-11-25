package com.aseck.lycee.controllers;

import com.aseck.lycee.entities.Eleve;
import com.aseck.lycee.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class EleveController  {

    @Autowired
    private EleveRepository eleveRepository;
    
    @RequestMapping("/")
    public String home() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
    	return "hello badou";
    }
    @RequestMapping("/add")
    public String creerEleve() {
        Eleve el = new Eleve();
        el.setNom("SECK");
        el.setPrenom("Alioune Badara");
        el.setDateNaissance(LocalDate.now());
        eleveRepository.save(el);
        return "creer";
    }

    @RequestMapping("/get")
    public List<Eleve> getEleve() {
        List<Eleve> els = new ArrayList<>();
        for (int i =0;i< 1;i++) {
            els.addAll(eleveRepository.findAll());
        }
        return els;
    }
}

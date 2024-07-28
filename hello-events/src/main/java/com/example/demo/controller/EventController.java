package com.example.demo.controller;

import com.example.demo.model.Evenement;
import com.example.demo.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/evenement")
public class EventController {

    @Autowired
    private EvenementService evenementService;

    @PostMapping("/admin")
    public Evenement addEvenement(@RequestBody Evenement evenement) {
        return evenementService.addEvenement(evenement);
    }

    @GetMapping("/")
    public List<Evenement> showEvenements() {
        return evenementService.showEvents();
    }

    @DeleteMapping("/admin/{id}")
    public void deleteEvent(@PathVariable Integer id) {
        evenementService.deleteEvent(id);
    }

    @GetMapping("/{idEvent}")
    public Evenement showEvenement(@PathVariable Integer idEvent) {
        return evenementService.showEvent(idEvent);
    }

    @PutMapping("/admin/update/{idEvenement}")
    public Evenement updateEvenement(@PathVariable Integer idEvenement, @RequestBody Evenement evenement) {
        return evenementService.updateEvent(idEvenement, evenement);
    }

    @GetMapping("/search")
    public List<Evenement> findEvents(@RequestParam(required = false) LocalDate date, @RequestParam(required = false) String categorie, @RequestParam(required = false) String lieu) {
        return evenementService.findEvents(date, categorie, lieu);
    }
}

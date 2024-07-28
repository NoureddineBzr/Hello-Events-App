package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/user")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/admin")
    public List<Reservation> showReservations() {
        return reservationService.showReservations();
    }

    @GetMapping("/user/{id}")
    public List<Reservation> showReservationsByIdUser(@PathVariable Integer id) {
        return reservationService.showReservationsByIdUser(id);
    }
}

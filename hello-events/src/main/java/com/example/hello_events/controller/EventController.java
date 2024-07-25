package com.example.hello_events.controller;


import com.example.hello_events.entities.Event;
import com.example.hello_events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("add-event")
    public Event createEvent(@RequestBody Event event){
        return eventService.createEvent(event);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }



}

package com.example.hello_events.controller;


import com.example.hello_events.entities.Event;
import com.example.hello_events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("all-events")
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.getAllEvent();
        return ResponseEntity.ok(events);
    }

    @PutMapping("update")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event){
        Event updateEvent = eventService.updateEvent(id, event);
        return ResponseEntity.ok(updateEvent);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEvent(@RequestParam(required = false) String category,
                                                   @RequestParam(required = false) String location,
                                                   @RequestParam(required = false) LocalDateTime startDAte,
                                                   @RequestParam(required = false) LocalDateTime endDate){
        List<Event> events = eventService.searchEvent(category, location, startDAte, endDate);
        return ResponseEntity.ok(events);
    }





}

package com.example.hello_events.service;

import com.example.hello_events.entities.Event;
import com.example.hello_events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepo;


    public Event createEvent(Event event) {
        return eventRepo.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);
    }

    public List<Event> getAllEvent() {
        return eventRepo.findAll();
    }

    public Event updateEvent(Long id, Event eventDetail) {
        Event event = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("event not found" + id));
        event.setName(eventDetail.getName());
        event.setDate(eventDetail.getDate());
        event.setLocation(event.getLocation());
        event.setDescription(eventDetail.getDescription());
        return eventRepo.save(event);
    }

    public List<Event> findByCategory(String category) {
        return eventRepo.findByCategory(category);
    }

    public List<Event> findByLocation(String location) {
        return eventRepo.findByLocation(location);
    }


    public List<Event> searchEvent(String category, String location, LocalDateTime startDate, LocalDateTime endDate) {
        if (category != null) {
            eventRepo.findByCategory(category);
        } else if (location != null) {
            eventRepo.findByLocation(location);
        } else if(startDate != null ) {
            eventRepo.findByDateBetween(startDate, endDate);
        }
        return eventRepo.findAll();

    }
}






package com.example.hello_events.service;

import com.example.hello_events.entities.Event;
import com.example.hello_events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.LongFunction;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepo;


    public Event createEvent(Event event){
        return eventRepo.save(event);
    }

    public void deleteEvent(Long id){
        eventRepo.deleteById(id);
    }

    public List<Event> getAllEvent(){
        return eventRepo.findAll();
    }

    public  Event updateEvent(Long id, Event event){
        return null;
    }


}

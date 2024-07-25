package com.example.hello_events.repository;

import com.example.hello_events.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findByCategory(String category);
    List<Event> findByLocation(String location);
    List<Event> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}

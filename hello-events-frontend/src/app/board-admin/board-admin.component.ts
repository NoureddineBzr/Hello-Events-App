import { Component, OnInit } from '@angular/core';
import { EventService } from '../services/event.service';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  events: any[] = [];
  newEvent: any = {};
  selectedEvent: any = {};

  constructor(private eventService: EventService) {}

  ngOnInit(): void {
    this.loadEvents();
  }

  loadEvents(): void {
    this.eventService.getAllEvents().subscribe(data => {
      this.events = data;
    });
  }

  addEvent(): void {
    this.eventService.createEvent(this.newEvent).subscribe(() => {
      this.loadEvents();
      this.newEvent = {}; // Reset the form
    });
  }

  editEvent(event: any): void {
    this.selectedEvent = { ...event };
  }

  updateEvent(): void {
    this.eventService.updateEvent(this.selectedEvent.idEvenement, this.selectedEvent).subscribe(() => {
      this.loadEvents();
      this.selectedEvent = {}; // Reset the form
    });
  }

  deleteEvent(id: number): void {
    this.eventService.deleteEvent(id).subscribe(() => {
      this.loadEvents();
    });
  }
}

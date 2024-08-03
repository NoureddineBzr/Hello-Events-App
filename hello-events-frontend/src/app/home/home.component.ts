import { Component, OnInit } from '@angular/core';
import { EventService } from '../services/event.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  events: any[] = [];
  content !: string;

  constructor(private eventService: EventService, private router: Router) { }

  ngOnInit(): void {
    this.eventService.getAllEvents().subscribe(data => {
      this.events = data;
    });
  }

  bookEvent(eventId: number): void {
    // Check if the user is logged in
    const isLoggedIn = !!localStorage.getItem('user'); // Adjust based on your auth logic

    if (isLoggedIn) {
      // Navigate to booking page (implement booking logic accordingly)
      this.router.navigate(['/book-event', eventId]);
    } else {
      // Navigate to login page
      this.router.navigate(['/login']);
    }
  }
}

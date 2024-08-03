import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'app-event-add',
  templateUrl: './event-add.component.html',
  styleUrls: ['./event-add.component.css']
})
export class EventAddComponent {
  event: any = {
    titre: '',
    description: '',
    lieu: '',
    dateEvenement: '',
    prix: '',
    categorie: '',
    heursEvenement: '',
    image: ''
  };

  constructor(private eventService: EventService, private router: Router) { }

  saveEvent(): void {
    this.eventService.createEvent(this.event).subscribe(() => {
      this.router.navigate(['/admin/events']);
    });
  }
}

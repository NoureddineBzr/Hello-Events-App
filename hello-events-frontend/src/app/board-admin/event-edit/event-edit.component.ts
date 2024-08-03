import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'app-event-edit',
  templateUrl: './event-edit.component.html',
  styleUrls: ['./event-edit.component.css']
})
export class EventEditComponent implements OnInit {
  event: any = {};

  constructor(
    private route: ActivatedRoute,
    private eventService: EventService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.eventService.getEventById(Number(id)).subscribe(data => {
      this.event = data;
    });
  }

  updateEvent(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.eventService.updateEvent(Number(id), this.event).subscribe(() => {
      this.router.navigate(['/admin/events']);
    });
  }
}

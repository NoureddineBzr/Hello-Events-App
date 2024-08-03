import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/events/';

@Injectable({
  providedIn: 'root',
})
export class EventService {
  constructor(private http: HttpClient) {}

  getAllEvents(): Observable<any> {
    return this.http.get(API_URL);
  }

  getEventById(id: number): Observable<any> {
    return this.http.get(`${API_URL}${id}`);
  }

  createEvent(event: any): Observable<any> {
    return this.http.post(API_URL, event);
  }

  updateEvent(id: number, event: any): Observable<any> {
    return this.http.put(`${API_URL}${id}`, event);
  }

  deleteEvent(id: number): Observable<any> {
    return this.http.delete(`${API_URL}${id}`);
  }
}

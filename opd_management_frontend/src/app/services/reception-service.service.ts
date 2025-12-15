import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReceptionService {

  private api = 'http://localhost:8080/receptions';

  constructor(private http: HttpClient) {}

  // Get receptions of logged-in doctor
  getReceptionsByDoctor(doctorId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.api}/doctor/${doctorId}`);
  }

  // Add reception
  addReception(data: any): Observable<any> {
    return this.http.post(`${this.api}/`, data);
  }

  // Update reception
  updateReception(id: number, data: any): Observable<any> {
    return this.http.put(`${this.api}/${id}`, data);
  }

  // Delete reception
  deleteReception(id: number): Observable<any> {
    return this.http.delete(`${this.api}/${id}`);
  }

  // Reception login
  loginReception(data: any): Observable<any> {
    return this.http.post(`${this.api}/login`, data);
  }
}

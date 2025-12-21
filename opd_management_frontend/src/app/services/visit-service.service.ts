import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  private api = 'http://localhost:8080/visits/';

  constructor(private http: HttpClient) {}

  createVisit(data: any) {
    return this.http.post(this.api, data);
  }

  getVisitsByDoctor(doctorId: number) {
    return this.http.get<any[]>(`${this.api}doctor/${doctorId}`);
  }
}

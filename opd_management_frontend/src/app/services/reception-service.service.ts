import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReceptionService {

  private api = 'http://localhost:8080/receptions';

  constructor(private http: HttpClient) {}

  getReceptionsByDoctor(doctorId: number) {
    return this.http.get<any[]>(`${this.api}/doctor/${doctorId}`);
  }

  addReception(data: any) {
    return this.http.post(`${this.api}/`, data);
  }

   loginReception(data: any) {
    return this.http.post(`${this.api}/login`, data);
  }
  
}

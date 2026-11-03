import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {
  private baseUrl = 'http://localhost:8080/api/medicines';

  constructor(private http: HttpClient) {}

  getAllMedicines(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getMedicineById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getMedicinesByDoctor(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/doctor/${doctorId}`);
  }

  getMedicinesByDoctorId(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/doctor/${doctorId}`);
  }

  addMedicine(medicine: any): Observable<any> {
    return this.http.post(this.baseUrl, medicine);
  }

  updateMedicine(id: number, medicine: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, medicine);
  }

  deleteMedicine(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}

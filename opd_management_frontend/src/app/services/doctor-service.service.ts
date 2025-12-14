import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private api = "http://localhost:8080/doctors";

  constructor(private http: HttpClient) {}

  // REGISTER
  registerDoctor(data: any): Observable<any> {
    return this.http.post(this.api + "/", data, {
      headers: { "Content-Type": "application/json" }
    });
  }

  // LOGIN
  loginDoctor(credentials: any): Observable<any> {
    return this.http.post(this.api + "/login", credentials, {
      headers: { "Content-Type": "application/json" }
    });
  }

  // ✅ UPDATE PROFILE
  updateDoctor(id: number, doctor: any): Observable<any> {
    return this.http.put(`${this.api}/${id}`, doctor);
  }

  // ✅ DELETE PROFILE
  deleteDoctor(id: number): Observable<any> {
    return this.http.delete(`${this.api}/${id}`);
  }
}

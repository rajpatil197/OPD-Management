import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private api = "http://localhost:8080/doctors/";

  constructor(private http: HttpClient) {}

  registerDoctor(data: any): Observable<any> {
    return this.http.post(this.api, data, {
      headers: { "Content-Type": "application/json" }
    });
  }

  loginDoctor(credentials: any): Observable<any> {
    return this.http.post(this.api + "login", credentials, {
      headers: { "Content-Type": "application/json" }
    });
  }
}

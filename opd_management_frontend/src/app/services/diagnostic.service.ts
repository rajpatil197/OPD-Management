import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DiagnosticService {
  private baseUrl = 'http://localhost:8080/api/diagnostics';

  constructor(private http: HttpClient) {}

  getAllDiagnostics(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getDiagnosticById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getDiagnosticsByVisitId(visitId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/visit/${visitId}`);
  }

  getDiagnosticsByDoctor(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/doctor/${doctorId}`);
  }

  getDiagnosticsByDoctorId(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/doctor/${doctorId}`);
  }

  addDiagnostic(diagnostic: any): Observable<any> {
    return this.http.post(this.baseUrl, diagnostic);
  }

  updateDiagnostic(id: number, diagnostic: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, diagnostic);
  }

  deleteDiagnostic(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VisitReportService {
  private baseUrl = 'http://localhost:8080/api/visit-reports';

  constructor(private http: HttpClient) {}

  getAllVisitReports(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getVisitReportById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getVisitReportsByVisitId(visitId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/visit/${visitId}`);
  }

  addVisitReport(report: any): Observable<any> {
    return this.http.post(this.baseUrl, report);
  }

  updateVisitReport(id: number, report: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, report);
  }

  deleteVisitReport(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}


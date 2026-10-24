import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PathologyTestService {
  private baseUrl = 'http://localhost:8080/api/pathology-tests';

  constructor(private http: HttpClient) {}

  getAllPathologyTests(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getPathologyTestById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getPathologyTestsByVisitId(visitId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/visit/${visitId}`);
  }

  addPathologyTest(test: any): Observable<any> {
    return this.http.post(this.baseUrl, test);
  }

  updatePathologyTest(id: number, test: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, test);
  }

  deletePathologyTest(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}

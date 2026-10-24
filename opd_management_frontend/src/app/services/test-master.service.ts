import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestMasterService {
  private baseUrl = 'http://localhost:8080/api/test-masters';

  constructor(private http: HttpClient) {}

  getAllTestMasters(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getTestMasterById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getTestMastersByDoctor(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/doctor/${doctorId}`);
  }

  getTestMastersByDoctorId(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/doctor/${doctorId}`);
  }

  addTestMaster(testMaster: any): Observable<any> {
    return this.http.post(this.baseUrl, testMaster);
  }

  updateTestMaster(id: number, testMaster: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, testMaster);
  }

  deleteTestMaster(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}

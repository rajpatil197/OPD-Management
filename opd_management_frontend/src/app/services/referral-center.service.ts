import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReferralCenterService {
  private baseUrl = 'http://localhost:8080/api/referral-centers';

  constructor(private http: HttpClient) {}

  getAllReferralCenters(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getReferralCenterById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getReferralCentersByDoctor(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/doctor/${doctorId}`);
  }

  getReferralCentersByDoctorId(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/doctor/${doctorId}`);
  }

  addReferralCenter(center: any): Observable<any> {
    return this.http.post(this.baseUrl, center);
  }

  updateReferralCenter(id: number, center: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, center);
  }

  deleteReferralCenter(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReferralService {
  private baseUrl = 'http://localhost:8080/api/referrals';

  constructor(private http: HttpClient) {}

  getAllReferrals(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getReferralById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getReferralsByVisitId(visitId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/visit/${visitId}`);
  }

  addReferral(referral: any): Observable<any> {
    return this.http.post(this.baseUrl, referral);
  }

  updateReferral(id: number, referral: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, referral);
  }

  deleteReferral(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}

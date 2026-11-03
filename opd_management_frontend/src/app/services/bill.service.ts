import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BillService {
  private baseUrl = 'http://localhost:8080/api/bills';

  constructor(private http: HttpClient) {}

  getAllBills(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getBillById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getBillsByVisitId(visitId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/visit/${visitId}`);
  }

  addBill(bill: any): Observable<any> {
    return this.http.post(this.baseUrl, bill);
  }

  updateBill(id: number, bill: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, bill);
  }

  deleteBill(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}


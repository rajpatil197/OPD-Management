import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  private api = 'http://localhost:8080/visits/'; 

  constructor(private http: HttpClient) {}

  // Create visit (Reception)
  createVisit(data: any): Observable<any> {
    return this.http.post(this.api, data);
  }

  // Get all visits of a doctor (Doctor Dashboard)
   getVisitsByDoctor(doctorId: number): Observable<any[]> {
    return this.http.get<any[]>(this.api + "doctor/" + doctorId);
  }

  getVisitById(id:Number){
    return this.http.get(this.api + id);
  }

  updateVisit(id:number,data:any){
    return this.http.put(this.api + id,data);
  }
}

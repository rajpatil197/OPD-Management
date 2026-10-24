import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

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

  // Get all visits
  getAllVisits(): Observable<any[]> {
    return this.http.get<any[]>(this.api).pipe(
      catchError(() => of([]))
    );
  }

  // Get all visits of a doctor (Doctor Dashboard)
  getVisitsByDoctor(doctorId: number): Observable<any[]> {
    return this.http.get<any[]>(this.api + "doctor/" + doctorId);
  }

  // Get all visits of a patient
  getVisitsByPatientId(patientId: number): Observable<any[]> {
    return this.http.get<any[]>(this.api).pipe(
      map(visits => (visits || []).filter(v => v.patientid?.id === patientId || v.patientId === patientId || v.patient?.id === patientId)),
      catchError(() => of([]))
    );
  }

  getVisitById(id:Number){
    return this.http.get<any>(this.api + id);
  }

  updateVisit(id:number,data:any){
    return this.http.put(this.api + id,data);
  }
}

export { VisitService as VisitServiceService };


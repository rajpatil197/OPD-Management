import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private api = "http://localhost:8080/patients/";

  constructor(private http: HttpClient) {}

  // 🔹 Get all patients
  getAllPatients(): Observable<any[]> {
    return this.http.get<any[]>(this.api);
  }

  // 🔹 Add patient
  addPatient(data: any): Observable<any> {
    return this.http.post(this.api, data);
  }

  // 🔹 Delete patient
  deletePatient(id: number): Observable<any> {
    return this.http.delete(this.api + id);
  }

  // 🔹 Get patients by doctor
  getPatientsByDoctor(doctorId: number): Observable<any[]> {
    return this.http.get<any[]>(this.api + "doctor/" + doctorId);
  }

  // ✅ REQUIRED FOR VIEW
  getPatientById(id: number): Observable<any> {
    return this.http.get<any>(this.api + id);
  }

  // ✅ REQUIRED FOR EDIT
  updatePatient(id: number, data: any): Observable<any> {
    return this.http.put(this.api + id, data);
  }
}

export { PatientService as PatientServiceService };


import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  api = "http://localhost:8080/patients/";

  constructor(private http: HttpClient) {}

  getAllPatients() {
    return this.http.get<any[]>(this.api);
  }

  addPatient(data: any) {
    return this.http.post(this.api, data);
  }

  deletePatient(id: number) {
    return this.http.delete(this.api + id);
  }

  getPatientsByDoctor(doctorId: number) {
  return this.http.get<any[]>(this.api + "doctor/" + doctorId);
}


}

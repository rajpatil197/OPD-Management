import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from '../../services/patient-service.service';


@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent {

  patient = {
  patient_name: "",
  mobileno: "",
  age: "",
  gender: "",
  blood_group: "",
  height: "",
  smoking: "",
  alcohol: "",
  tobacco: "",
  address: "",
  doctorid: Number(localStorage.getItem("doctorId")), // dynamic doctor
  created_at: new Date().toISOString().slice(0,10)
};


  constructor(private patientService: PatientService, private router: Router) {}

  savePatient() {
    this.patientService.addPatient(this.patient).subscribe({
      next: () => {
        alert("Patient saved successfully!");
        this.router.navigate(['/patients']);
      },
      error: () => alert("Failed to save patient")
    });
  }

}

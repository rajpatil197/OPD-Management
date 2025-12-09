import { Component, OnInit } from '@angular/core';
import { PatientService } from '../services/patient-service.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: any[] = [];

  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.loadPatientsOfLoggedInDoctor();
  }

  loadPatientsOfLoggedInDoctor() {
    //Get the logged-in doctor ID from localStorage
    const doctorId = Number(localStorage.getItem("doctorId"));

    if (!doctorId) {
      alert("Doctor not logged in!");
      return;
    }

    // Fetch patients assigned only to this doctor
    this.patientService.getPatientsByDoctor(doctorId).subscribe({
      next: (res) => {
        this.patients = res;
      },
      error: () => {
        alert("No patients found for this doctor");
      }
    });
  }
}

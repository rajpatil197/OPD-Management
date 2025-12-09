import { Component, OnInit } from '@angular/core';
import { PatientService } from '../services/patient-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  totalPatients = 0;  
  todaysAppointments = 0; // optional, if you implement later
  pendingReports = 0;     // optional

  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.loadPatientCount();
  }

  loadPatientCount() {
    const doctorId = Number(localStorage.getItem("doctorId"));

    if (!doctorId) {
      console.error("Doctor not logged in");
      return;
    }

    this.patientService.getPatientsByDoctor(doctorId).subscribe({
      next: (patients) => {
        this.totalPatients = patients.length;
      },
      error: () => {
        this.totalPatients = 0;
      }
    });
  }
}

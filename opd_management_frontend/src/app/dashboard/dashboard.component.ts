import { Component, OnInit } from '@angular/core';
import { PatientService } from '../services/patient-service.service';
import { ReceptionService } from '../services/reception-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  totalPatients = 0;
  todayPatients = 0;
  totalReceptions = 0;

  doctor: any = null;
  recentPatients: any[] = [];

  patients: any[] = [];
  receptions: any[] = [];

  doctorId!: number;

  constructor(
    private patientService: PatientService,
    private receptionService: ReceptionService
  ) {}

  ngOnInit(): void {

    const storedDoctor = localStorage.getItem('doctor');

    if (!storedDoctor) {
      alert('Doctor not logged in');
      return;
    }

    const doctorObj = JSON.parse(storedDoctor);

    //  CORRECT doctorId
    this.doctorId = doctorObj.doctorId;
    this.doctor = doctorObj;

    this.loadPatients();
    this.loadReceptions();
  }

  loadPatients() {
    this.patientService.getPatientsByDoctor(this.doctorId).subscribe({
      next: (res) => {
        this.patients = res || [];
        this.totalPatients = this.patients.length;

        const today = new Date().toISOString().slice(0, 10);

        this.todayPatients = this.patients.filter((p: any) => {
          const createdDate = p.created_at?.slice(0, 10);
          return createdDate === today;
        }).length;

        this.recentPatients = this.patients.slice(0, 5);
      },
      error: (err) => {
        console.error(err);
        alert('Failed to load patients');
      }
    });
  }

  loadReceptions() {
    this.receptionService.getReceptionsByDoctor(this.doctorId).subscribe({
      next: (res) => {
        this.receptions = res || [];
        this.totalReceptions = this.receptions.length;
      },
      error: (err) => {
        console.error(err);
        alert('Failed to load receptions');
      }
    });
  }
}

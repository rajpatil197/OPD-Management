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

  recentPatients: any[] = [];

  doctorId!: number;

  constructor(
    private patientService: PatientService,
    private receptionService: ReceptionService
  ) {}

  ngOnInit(): void {
    this.doctorId = Number(localStorage.getItem('doctorId'));

    this.loadPatients();
    this.loadReceptions();
  }

  loadPatients() {
    this.patientService.getPatientsByDoctor(this.doctorId).subscribe(res => {
      this.totalPatients = res.length;

      const today = new Date().toISOString().slice(0, 10);

      this.todayPatients = res.filter(
        (p: any) => p.created_at === today
      ).length;

      this.recentPatients = res.slice(0, 5);
    });
  }

  loadReceptions() {
    this.receptionService.getReceptionsByDoctor(this.doctorId).subscribe(res => {
      this.totalReceptions = res.length;
    });
  }
}

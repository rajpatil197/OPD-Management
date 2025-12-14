import { Component, OnInit } from '@angular/core';
import { PatientService } from '../../services/patient-service.service';

@Component({
  selector: 'app-reception-dashboard',
  templateUrl: './reception-dashboard.component.html'
})
export class ReceptionDashboardComponent implements OnInit {

  totalPatients = 0;
  todayPatients = 0;

  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.patientService.getAllPatients().subscribe(res => {
      this.totalPatients = res.length;

      const today = new Date().toISOString().slice(0, 10);
      this.todayPatients = res.filter(p => p.created_at === today).length;
    });
  }
}

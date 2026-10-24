import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VisitServiceService } from '../../services/visit-service.service';
import { PatientServiceService } from '../../services/patient-service.service';

@Component({
  selector: 'app-patient-visits',
  templateUrl: './patient-visits.component.html',
  styleUrls: ['./patient-visits.component.css']
})
export class PatientVisitsComponent implements OnInit {
  patientId: number = 0;
  patient: any = null;
  visits: any[] = [];

  constructor(
    private route: ActivatedRoute,
    public router: Router,
    private visitService: VisitServiceService,
    private patientService: PatientServiceService
  ) {}

  ngOnInit(): void {
    this.patientId = +this.route.snapshot.paramMap.get('id')!;
    if (this.patientId) {
      this.patientService.getPatientById(this.patientId).subscribe({
        next: (data: any) => this.patient = data,
        error: (err: any) => console.error('Failed to load patient details', err)
      });
      this.visitService.getVisitsByPatientId(this.patientId).subscribe({
        next: (data: any) => this.visits = data || [],
        error: (err: any) => console.error('Failed to load visit history', err)
      });
    }
  }
}

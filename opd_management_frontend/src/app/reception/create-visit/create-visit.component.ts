import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from 'src/app/services/patient-service.service';
import { VisitService } from 'src/app/services/visit-service.service';

@Component({
  selector: 'app-create-visit',
  templateUrl: './create-visit.component.html'
})
export class CreateVisitComponent implements OnInit {

  patients: any[] = [];

  visit = {
    visit_date: '',
    complaints: '',
    created_at: '',
    updated_at: '',
    weight:'',
    doctorid: 0,
    patientid: 0
  };

  constructor(
    private patientService: PatientService,
    private visitService: VisitService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadPatients();
    this.setDoctorId();
    this.setDates();
  }

  // Load patients for this doctor
  loadPatients() {
    let doctorId: number | null = null;

    const reception = localStorage.getItem('reception');
    if (reception) {
      doctorId = JSON.parse(reception).doctorid?.id;
    }

    if (!doctorId) {
      alert('Doctor not found');
      return;
    }

    this.patientService.getPatientsByDoctor(doctorId).subscribe({
      next: res => this.patients = res,
      error: () => alert('Failed to load patients')
    });
  }

  // Set doctor ID from reception login
  setDoctorId() {
    const reception = localStorage.getItem('reception');
    if (reception) {
      this.visit.doctorid = JSON.parse(reception).doctorid?.id;
    }
  }

  // Set created & updated dates
  setDates() {
    const today = new Date().toISOString().split('T')[0];
    this.visit.created_at = today;
    this.visit.updated_at = today;
    this.visit.visit_date = today;
  }

  createVisit() {
    if (!this.visit.patientid || !this.visit.complaints) {
      alert('Please select patient and enter complaints');
      return;
    }

    this.visitService.createVisit(this.visit).subscribe({
      next: () => {
        alert('Visit created successfully');
        this.router.navigate(['/reception/dashboard']);
      },
      error: (err) => {
        console.error(err);
        alert('Failed to create visit');
      }
    });
  }
}

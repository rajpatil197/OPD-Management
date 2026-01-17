import { Component, OnInit } from '@angular/core';
import { PatientService } from '../services/patient-service.service';
import { Router } from '@angular/router';

declare var bootstrap: any;

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html'
})
export class PatientListComponent implements OnInit {

  patients: any[] = [];
  filteredPatients: any[] = [];
  selectedPatient: any = null;
  searchText = '';

  constructor(
    private patientService: PatientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients() {
  let doctorId: number | null = null;

  const doctorStr = localStorage.getItem('doctor');
  if (doctorStr) {
    const doctorObj = JSON.parse(doctorStr);

    // CORRECT KEY
    doctorId = doctorObj.doctorId;
  }

  const receptionStr = localStorage.getItem('reception');
  if (!doctorId && receptionStr) {
    const receptionObj = JSON.parse(receptionStr);
    doctorId = receptionObj.doctorid?.id;
  }

  if (!doctorId) {
    alert('Unauthorized');
    return;
  }

  this.patientService.getPatientsByDoctor(doctorId).subscribe({
    next: (res) => {
      this.patients = res || [];
      this.filteredPatients = res || [];
    },
    error: (err) => {
      console.error(err);
      alert('Failed to load patients');
    }
  });
}


  //  Search
  applySearch() {
    const s = this.searchText.toLowerCase();
    this.filteredPatients = this.patients.filter(p =>
      p.patient_name.toLowerCase().includes(s) ||
      p.mobileno.includes(s)
    );
  }

  //  View modal
  openViewModal(patient: any) {
    this.selectedPatient = patient;
    const modal = new bootstrap.Modal(
      document.getElementById('viewPatientModal')
    );
    modal.show();
  }

  //  Edit
 editPatient(patient: any) {

  // Doctor logged in
  if (localStorage.getItem('doctor')) {
    this.router.navigate(['/doctor/edit-patient', patient.id]);
    return;
  }

  // Reception logged in
  if (localStorage.getItem('reception')) {
    this.router.navigate(['/reception/edit-patient', patient.id]);
    return;
  }

  alert('Unauthorized');
}


  //  Delete
  deletePatient(id: number) {
    if (confirm('Are you sure?')) {
      this.patientService.deletePatient(id).subscribe(() => {
        alert('Patient deleted');
        this.loadPatients();
      });
    }
  }
}

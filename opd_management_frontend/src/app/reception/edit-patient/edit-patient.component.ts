import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../../services/patient-service.service';

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html'
})
export class EditPatientComponent implements OnInit {

  patient: any = {};

  constructor(
    private route: ActivatedRoute,
    private patientService: PatientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.patientService.getPatientById(id).subscribe({
      next: res => this.patient = res,
      error: () => alert('Failed to load patient')
    });
  }

  updatePatient() {

  // doctorId from logged in user
  let doctorId: number | null = null;

  const doctor = localStorage.getItem('doctor');
  if (doctor) {
    doctorId = JSON.parse(doctor).id;
  }

  const reception = localStorage.getItem('reception');
  if (!doctorId && reception) {
    doctorId = JSON.parse(reception).doctorid?.id;
  }

  if (!doctorId) {
    alert('Unauthorized');
    return;
  }

  const payload = {
    patient_name: this.patient.patient_name,
    age: this.patient.age,
    gender: this.patient.gender,
    mobileno: this.patient.mobileno,
    address: this.patient.address,
    blood_group: this.patient.blood_group,
    height: this.patient.height,
    smoking: this.patient.smoking || 'No',
    alcohol: this.patient.alcohol || 'No',
    tobacco: this.patient.tobacco || 'No',
    created_at: this.patient.created_at,   // MUST EXIST
    doctorid: doctorId                     // MUST BE > 0
  };

  this.patientService.updatePatient(this.patient.id, payload).subscribe({
    next: () => {
      alert('Patient updated successfully');
    },
    error: err => {
      console.error(err);
      alert('Update failed – check required fields');
    }
  });
}

}

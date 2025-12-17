import { Component, OnInit } from '@angular/core';
import { PatientService } from '../services/patient-service.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: any[] = [];

   filteredPatients: any[] = [];

  searchText: string = '';

  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients() {

    let doctorId: number | null = null;

    //  Doctor logged in
    const doctor = localStorage.getItem('doctor');
    if (doctor) {
      doctorId = JSON.parse(doctor).id;
    }

    //  Reception logged in
    const reception = localStorage.getItem('reception');
    if (!doctorId && reception) {
      doctorId = JSON.parse(reception).doctorid?.id;
    }

    //  NO AUTH
    if (!doctorId) {
      alert('Unauthorized access');
      return;
    }

    //  Fetch patients of that doctor
    this.patientService.getPatientsByDoctor(doctorId).subscribe({
      next: (res) => {
        this.patients = res;
        this.filteredPatients = res;
      },
      error: () => {
        alert('No patients found');
      }
    });
  }

   ngOnChanges() {
    this.applySearch();
  }
   applySearch() {
    const search = this.searchText.toLowerCase();

    this.filteredPatients = this.patients.filter(p =>
      p.patient_name.toLowerCase().includes(search) ||
      p.mobileno.includes(search)
    );
  }
}

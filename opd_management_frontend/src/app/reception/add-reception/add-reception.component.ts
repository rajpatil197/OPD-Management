import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReceptionService } from 'src/app/services/reception-service.service';
import { DoctorService } from 'src/app/services/doctor-service.service';

@Component({
  selector: 'app-add-reception',
  templateUrl: './add-reception.component.html',
  styleUrls: ['./add-reception.component.css']
})
export class AddReceptionComponent implements OnInit {

  reception = {
    name: '',
    email: '',
    phoneNo: '',
    shift: 'Morning',
    password: '',
    doctorid: 0
  };

  doctors: any[] = [];
  isDoctorLoggedIn = false;
  loggedInDoctorName = '';
  errorMessage = '';
  successMessage = '';
  isLoading = false;
  showPassword = false;

  togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }

  constructor(
    private receptionService: ReceptionService,
    private doctorService: DoctorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const doctorStr = localStorage.getItem('doctor');

    if (doctorStr) {
      try {
        const doctorObj = JSON.parse(doctorStr);
        this.isDoctorLoggedIn = true;
        this.reception.doctorid = doctorObj.doctorId || doctorObj.id || 0;
        this.loggedInDoctorName = doctorObj.name || 'Your Clinic';
      } catch (e) {
        this.isDoctorLoggedIn = false;
      }
    }

    if (!this.isDoctorLoggedIn) {
      this.loadDoctors();
    }
  }

  loadDoctors(): void {
    this.doctorService.getAllDoctors().subscribe({
      next: (docs) => {
        this.doctors = docs || [];
        if (this.doctors.length > 0 && !this.reception.doctorid) {
          this.reception.doctorid = this.doctors[0].id || this.doctors[0].doctorId;
        }
      },
      error: (err) => {
        console.error('Failed to load doctors list', err);
      }
    });
  }

  saveReception() {
    this.errorMessage = '';
    this.successMessage = '';

    if (!this.reception.name || !this.reception.email || !this.reception.password || !this.reception.shift) {
      this.errorMessage = 'Please complete all required fields.';
      return;
    }

    if (!this.reception.doctorid || Number(this.reception.doctorid) === 0) {
      this.errorMessage = 'Please select a supervising doctor.';
      return;
    }

    this.isLoading = true;
    this.receptionService.addReception(this.reception).subscribe({
      next: () => {
        this.isLoading = false;
        this.successMessage = 'Receptionist account created successfully!';
        setTimeout(() => {
          if (this.isDoctorLoggedIn) {
            this.router.navigate(['/doctor/reception-list']);
          } else {
            this.router.navigate(['/reception-login']);
          }
        }, 1500);
      },
      error: (err) => {
        this.isLoading = false;
        console.error(err);
        this.errorMessage = err.error?.message || 'Failed to register receptionist. Please check details.';
      }
    });
  }
}

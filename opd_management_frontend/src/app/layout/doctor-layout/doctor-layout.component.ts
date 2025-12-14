import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { DoctorService } from 'src/app/services/doctor-service.service';

@Component({
  selector: 'app-doctor-layout',
  templateUrl: './doctor-layout.component.html',
  styleUrls: ['./doctor-layout.component.css']
})
export class DoctorLayoutComponent implements OnInit {

  doctor: any = null;

  constructor(
    private doctorService: DoctorService,
    private router: Router
  ) {}

  ngOnInit() {
    const storedDoctor = localStorage.getItem("doctor");
    if (storedDoctor) {
      this.doctor = JSON.parse(storedDoctor);
    }
  }

  updateProfile() {
    this.doctorService.updateDoctor(this.doctor.id, this.doctor).subscribe({
      next: (res) => {
        localStorage.setItem("doctor", JSON.stringify(res));
        alert("Profile updated successfully");
      },
      error: () => {
        alert("Failed to update profile");
      }
    });
  }

  deleteProfile() {
    if (!confirm("Are you sure you want to delete your profile?")) return;

    this.doctorService.deleteDoctor(this.doctor.id).subscribe({
      next: () => {
        alert("Profile deleted");
        localStorage.clear();
        this.router.navigate(['/login']);
      },
      error: () => {
        alert("Failed to delete profile");
      }
    });
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}

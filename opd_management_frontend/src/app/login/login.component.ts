import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DoctorService } from '../services/doctor-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private doctorService: DoctorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login() {
    if (this.loginForm.invalid) {
      alert("Enter Email & Password");
      return;
    }

    this.doctorService.loginDoctor(this.loginForm.value).subscribe({
      next: (doctor) => {
        alert("Login Successful!");

        // Save doctor object
        localStorage.setItem("doctor", JSON.stringify(doctor));

        // ⭐ IMPORTANT: save doctorId separately
        localStorage.setItem("doctorId", doctor.id.toString());

        // Redirect to dashboard
        this.router.navigate(['/dashboard']);
      },
      error: (err) => {
        if (err.status === 404) {
          alert("Email Not Found");
        } else if (err.status === 401) {
          alert("Incorrect Password");
        } else {
          alert("Login Failed");
        }
      }
    });
  }
}

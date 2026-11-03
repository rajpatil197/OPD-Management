import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DoctorService } from '../services/doctor-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';
  isLoading: boolean = false;
  showPassword: boolean = false;

  constructor(
    private fb: FormBuilder,
    private doctorService: DoctorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }

  login(): void {
    this.errorMessage = '';
    this.successMessage = '';

    if (this.loginForm.invalid) {
      this.errorMessage = 'Please enter a valid email address and password.';
      return;
    }

    this.isLoading = true;

    this.doctorService.loginDoctor(this.loginForm.value).subscribe({
      next: (doctor: any) => {
        this.isLoading = false;
        this.successMessage = 'Login successful! Redirecting to doctor workspace...';

        // Save full response & tokens
        localStorage.setItem("doctor", JSON.stringify(doctor));
        if (doctor.doctorId) {
          localStorage.setItem("doctorId", doctor.doctorId.toString());
        }
        if (doctor.token) {
          localStorage.setItem("token", doctor.token);
        }
        if (doctor.email) {
          localStorage.setItem("email", doctor.email);
        }

        // Redirect to dashboard
        setTimeout(() => {
          this.router.navigate(['/doctor/dashboard']);
        }, 800);
      },
      error: (err) => {
        this.isLoading = false;
        console.error('Doctor login error:', err);
        if (err.status === 404) {
          this.errorMessage = 'Doctor account not found with this email. Please check spelling or register.';
        } else if (err.status === 401) {
          this.errorMessage = 'Incorrect password. Please verify and try again.';
        } else {
          this.errorMessage = err.error?.message || (typeof err.error === 'string' ? err.error : 'Doctor login failed. Please check credentials or server connection.');
        }
      }
    });
  }
}

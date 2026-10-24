import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DoctorService } from '../services/doctor-service.service';

@Component({
  selector: 'app-doctor-register',
  templateUrl: './doctor-register.component.html',
  styleUrls: ['./doctor-register.component.css']
})
export class DoctorRegisterComponent implements OnInit {

  registerForm!: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';
  isLoading: boolean = false;
  showPassword: boolean = false;
  showConfirmPassword: boolean = false;

  constructor(
    private fb: FormBuilder,
    private doctorService: DoctorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      specialization: ['', Validators.required],
      clinic_name: ['', Validators.required],
      qualification: ['', Validators.required],
      address: ['', Validators.required],
      mobileno: ['', [Validators.required, Validators.pattern('^[0-9]{10,12}$')]],
      password: ['', [Validators.required, Validators.minLength(4)]],
      confirmPassword: ['', Validators.required],
      token: [''],
      status: ['Active'],
      created_at: [new Date().toISOString().slice(0, 10)],
      updated_at: [new Date().toISOString().slice(0, 10)]
    });
  }

  togglePassword(): void {
    this.showPassword = !this.showPassword;
  }

  toggleConfirmPassword(): void {
    this.showConfirmPassword = !this.showConfirmPassword;
  }

  submitForm(): void {
    this.errorMessage = '';
    this.successMessage = '';

    if (this.registerForm.invalid) {
      this.errorMessage = 'Please fill out all required fields with valid information.';
      this.registerForm.markAllAsTouched();
      return;
    }

    if (this.registerForm.value.password !== this.registerForm.value.confirmPassword) {
      this.errorMessage = 'Passwords do not match. Please re-enter.';
      return;
    }

    const payload = { ...this.registerForm.value };
    delete payload.confirmPassword;

    this.isLoading = true;

    this.doctorService.registerDoctor(payload).subscribe({
      next: (res) => {
        this.isLoading = false;
        this.successMessage = 'Doctor account registered successfully! Redirecting to login...';
        this.registerForm.reset();
        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 1500);
      },
      error: (err) => {
        this.isLoading = false;
        console.error("Doctor registration error:", err);
        this.errorMessage = err.error?.message || (typeof err.error === 'string' ? err.error : "Registration failed. Please check information.");
      }
    });
  }
}

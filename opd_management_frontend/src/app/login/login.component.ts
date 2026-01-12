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
    next: (doctor: any) => {
      alert("Login Successful!");

      // Save full response
      localStorage.setItem("doctor", JSON.stringify(doctor));

      // Save required fields
      localStorage.setItem("doctorId", doctor.doctorId.toString());
      localStorage.setItem("token", doctor.token);
      localStorage.setItem("email", doctor.email);

      // Redirect
      this.router.navigate(['/doctor/dashboard']);
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

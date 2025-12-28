import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DoctorService } from '../services/doctor-service.service';


@Component({
  selector: 'app-doctor-register',
  templateUrl: './doctor-register.component.html',
  styleUrls: ['./doctor-register.component.css']
})
export class DoctorRegisterComponent {

  registerForm!: FormGroup;

  constructor(private fb: FormBuilder, private doctorService:DoctorService) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      specialization: ['', Validators.required],
      clinic_name: ['', Validators.required],
      qualification:['',Validators.required],
      address: ['',Validators.required],
      mobileno: ['',Validators.required],

      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],

      token: [''],
      status: ['Active'],

      created_at: [new Date().toISOString().slice(0, 10)],
      updated_at: [new Date().toISOString().slice(0, 10)]
    });
  }

  submitForm() {
    if (this.registerForm.invalid) {
      alert("Please fill required fields");
      return;
    }

    if (this.registerForm.value.password !== this.registerForm.value.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

    const payload = { ...this.registerForm.value };
    delete payload.confirmPassword;

    console.log("Sending payload:", payload);

    this.doctorService.registerDoctor(payload).subscribe({
      next: (res) => {
        alert("Doctor Registered Successfully!");
        this.registerForm.reset();
      },
      error: (err) => {
        console.error("Error:", err);
        alert("Registration Failed!");
      }
    });
  }
}

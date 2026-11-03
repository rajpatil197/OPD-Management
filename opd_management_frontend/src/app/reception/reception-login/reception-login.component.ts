import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ReceptionService } from 'src/app/services/reception-service.service';

@Component({
  selector: 'app-reception-login',
  templateUrl: './reception-login.component.html',
  styleUrls: ['./reception-login.component.css']
})
export class ReceptionLoginComponent {

  reception = {
    email: '',
    password: ''
  };

  errorMessage: string = '';
  successMessage: string = '';
  isLoading: boolean = false;
  showPassword: boolean = false;

  constructor(
    private receptionService: ReceptionService,
    private router: Router
  ) {}

  togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }

  login(): void {
    this.errorMessage = '';
    this.successMessage = '';

    if (!this.reception.email || !this.reception.password) {
      this.errorMessage = 'Please enter both your email address and password.';
      return;
    }

    this.isLoading = true;

    this.receptionService.loginReception(this.reception).subscribe({
      next: (res: any) => {
        this.isLoading = false;
        this.successMessage = 'Reception login successful! Redirecting to front-desk dashboard...';

        // ✅ Save reception object
        localStorage.setItem('reception', JSON.stringify(res));

        // ✅ Save token for AuthInterceptor
        if (res.token) {
          localStorage.setItem('token', res.token);
        }

        // ✅ Save doctorId
        const docId = res.doctorid?.id || res.doctor?.id;
        if (docId) {
          localStorage.setItem('doctorId', docId.toString());
        }

        // ✅ Redirect
        setTimeout(() => {
          this.router.navigate(['/reception/dashboard']);
        }, 800);
      },
      error: (err) => {
        this.isLoading = false;
        console.error('Reception login error:', err);
        if (err.status === 404) {
          this.errorMessage = 'Receptionist account not found with this email.';
        } else if (err.status === 401) {
          this.errorMessage = 'Incorrect password. Please verify and try again.';
        } else {
          this.errorMessage = err.error?.message || 'Invalid email or password. Please try again.';
        }
      }
    });
  }
}

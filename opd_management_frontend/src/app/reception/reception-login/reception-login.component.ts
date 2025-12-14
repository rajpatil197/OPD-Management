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

  constructor(
    private receptionService: ReceptionService,
    private router: Router
  ) {}

  login() {
    this.receptionService.loginReception(this.reception).subscribe({
      next: (res: any) => {

        // ✅ Save reception
        localStorage.setItem('reception', JSON.stringify(res));

        // ✅ VERY IMPORTANT: Save doctorId
        localStorage.setItem('doctorId', res.doctorid.id);

        alert("Reception login successful");

        // ✅ Redirect
        this.router.navigate(['/reception/dashboard']);
      },
      error: () => {
        alert('Invalid email or password');
      }
    });
  }
}

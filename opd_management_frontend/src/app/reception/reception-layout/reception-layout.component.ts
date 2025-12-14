import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reception-layout',
  templateUrl: './reception-layout.component.html',
  styleUrls: ['./reception-layout.component.css']
})
export class ReceptionLayoutComponent {

  constructor(private router: Router) {}

  logout() {
    localStorage.removeItem('reception');
    localStorage.removeItem('receptionId');
    this.router.navigate(['/reception-login']);
  }
}

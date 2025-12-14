import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ReceptionAuthGuard implements CanActivate{

  constructor(private router: Router) {}

  canActivate(): boolean {

    const reception = localStorage.getItem('reception');

    if (reception) {
      return true; // Reception logged in
    }

    // Not logged in → redirect to reception login
    this.router.navigate(['/reception-login']);
    return false;
  }
}

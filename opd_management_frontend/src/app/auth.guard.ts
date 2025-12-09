import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {

  const router = inject(Router);
  const doctorId = localStorage.getItem("doctorId");

  if (doctorId) {
    return true;  // Allow route access
  }

  // Not logged in → redirect to login
  router.navigate(['/login']);
  return false;
};

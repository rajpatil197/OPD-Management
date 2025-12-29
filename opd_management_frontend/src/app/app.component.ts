import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  showHeader = true;

  constructor(private router: Router) {

    this.router.events.subscribe(event => {

      // ✅ Only react after navigation ends
      if (event instanceof NavigationEnd) {

        const noHeaderRoutes = [
          '/doctor/dashboard',
          '/doctor/patients',
          '/doctor/reception-list',
          '/doctor/add-reception',
          '/reception/dashboard',
          '/reception/add-patient',
          '/reception/patients',
          '/reception/edit-patient',
          '/doctor/edit-patient',
          '/reception/create-visit',
          '/doctor/visit-list',
          '/doctor/visit'
        ];

        this.showHeader = !noHeaderRoutes.some(route =>
          event.urlAfterRedirects.startsWith(route)
        );
      }

    });
  }
}

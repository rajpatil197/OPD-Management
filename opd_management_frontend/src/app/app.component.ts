import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  showHeader = true;

  constructor(private router: Router) {
    router.events.subscribe(() => {
      const noHeaderRoutes = [
        '/dashboard',
        '/patients',
        '/add-patient'
      ];

      this.showHeader = !noHeaderRoutes.includes(router.url);
    });
  }

}

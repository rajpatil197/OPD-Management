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

      if (event instanceof NavigationEnd) {
        // Hide main public header inside doctor and reception dashboard layouts
        const isDashboardRoute =
          event.urlAfterRedirects.startsWith('/doctor/') ||
          event.urlAfterRedirects === '/doctor' ||
          event.urlAfterRedirects.startsWith('/reception/') ||
          event.urlAfterRedirects === '/reception';

        this.showHeader = !isDashboardRoute;
      }

    });
  }
}

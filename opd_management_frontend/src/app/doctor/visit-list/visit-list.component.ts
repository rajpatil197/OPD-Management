import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { VisitService } from 'src/app/services/visit-service.service';

@Component({
  selector: 'app-visit-list',
  templateUrl: './visit-list.component.html'
})
export class VisitListComponent implements OnInit {

  visits: any[] = [];

  constructor(
    private visitService: VisitService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadVisits();
  }

  loadVisits() {
    const doctor = localStorage.getItem('doctor');

    if (!doctor) {
      alert('Doctor not logged in');
      return;
    }

    const doctorId = JSON.parse(doctor).id;

    this.visitService.getVisitsByDoctor(doctorId).subscribe({
      next: (res) => this.visits = res,
      error: () => alert('Failed to load visits')
    });
  }

  openVisit(visitId: number) {
    this.router.navigate(['/doctor/visit', visitId]);
  }
}

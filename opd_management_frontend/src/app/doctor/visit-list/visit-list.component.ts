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
    const doctorStr = localStorage.getItem('doctor');

    if (!doctorStr) {
      alert('Doctor not logged in');
      return;
    }

    const doctor = JSON.parse(doctorStr);

    this.visitService.getVisitsByDoctor(doctor.id).subscribe({
      next: (res) => {
        console.log('Doctor visits:', res);
        this.visits = res;
      },
      error: (err) => {
        console.error(err);
        alert('Failed to load visits');
      }
    });
  }

  openVisit(visitId: number) {
    this.router.navigate(['/doctor/visit', visitId]);
  }
}

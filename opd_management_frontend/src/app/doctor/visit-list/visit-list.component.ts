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
  const auth = localStorage.getItem('doctor');

  if (!auth) {
    alert('Doctor not logged in');
    return;
  }

  const doctorObj = JSON.parse(auth);

  // ✅ FIX HERE
  const doctorId = doctorObj.id || doctorObj.doctor?.id;

  if (!doctorId) {
    alert('Doctor ID missing');
    return;
  }

  this.visitService.getVisitsByDoctor(doctorId).subscribe({
    next: res => this.visits = res || [],
    error: err => console.error(err)
  });
}


  openVisit(visitId: number) {
    this.router.navigate(['/doctor/visit', visitId]);
  }
}

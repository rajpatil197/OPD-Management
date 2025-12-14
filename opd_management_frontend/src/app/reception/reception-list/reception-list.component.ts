import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ReceptionService } from 'src/app/services/reception-service.service';

@Component({
  selector: 'app-reception-list',
  templateUrl: './reception-list.component.html'
})
export class ReceptionListComponent implements OnInit {

  receptions: any[] = [];

  constructor(
    private receptionService:ReceptionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadReceptions();
  }

  loadReceptions() {
    const doctorId = Number(localStorage.getItem("doctorId"));

    this.receptionService.getReceptionsByDoctor(doctorId).subscribe({
      next: res => this.receptions = res,
      error: () => alert("Failed to load receptions")
    });
  }

  addReception() {
    this.router.navigate(['/doctor/add-reception']);
  }
}

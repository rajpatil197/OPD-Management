import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReceptionService } from 'src/app/services/reception-service.service';

declare var bootstrap: any; // REQUIRED for modal

@Component({
  selector: 'app-reception-list',
  templateUrl: './reception-list.component.html'
})
export class ReceptionListComponent implements OnInit {

  receptions: any[] = [];
  selectedReception: any = {};

  constructor(
    private receptionService: ReceptionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadReceptions();
  }

  loadReceptions() {
    const doctorId = Number(localStorage.getItem('doctorId'));

    if (!doctorId) {
      alert('Doctor not logged in');
      return;
    }

    this.receptionService.getReceptionsByDoctor(doctorId).subscribe({
      next: res => this.receptions = res,
      error: () => alert('Failed to load receptions')
    });
  }

  addReception() {
    this.router.navigate(['/doctor/add-reception']);
  }

  // ===== EDIT =====
  openEditModal(reception: any) {
    this.selectedReception = { ...reception };

    const modal = new bootstrap.Modal(
      document.getElementById('editReceptionModal')
    );
    modal.show();
  }

  updateReception() {

  const doctorId = Number(localStorage.getItem('doctorId'));

  const payload = {
    ...this.selectedReception,
    doctorid: doctorId,      // ✅ REQUIRED
    password: this.selectedReception.password || 'default123'
  };

  this.receptionService
    .updateReception(this.selectedReception.id, payload)
    .subscribe({
      next: () => {
        alert('Reception updated successfully');
        this.loadReceptions();

        const modalEl = document.getElementById('editReceptionModal');
        bootstrap.Modal.getInstance(modalEl)?.hide();
      },
      error: err => {
        console.error(err);
        alert('Update failed');
      }
    });
}


  // ===== DELETE =====
  deleteReception(id: number) {
    if (!confirm('Are you sure you want to delete this reception?')) return;

    this.receptionService.deleteReception(id).subscribe({
      next: () => {
        alert('Reception deleted');
        this.loadReceptions();
      },
      error: () => alert('Delete failed')
    });
  }
}

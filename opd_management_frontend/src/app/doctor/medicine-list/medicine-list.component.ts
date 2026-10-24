import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../../services/medicine.service';

@Component({
  selector: 'app-medicine-list',
  templateUrl: './medicine-list.component.html',
  styleUrls: ['./medicine-list.component.css']
})
export class MedicineListComponent implements OnInit {
  medicines: any[] = [];
  newMedicine: any = { medicineName: '', type: 'Tablet', doctorId: 0 };
  successMsg = '';
  errorMsg = '';

  constructor(private medicineService: MedicineService) {}

  ngOnInit(): void {
    const doctor = JSON.parse(localStorage.getItem('doctor') || '{}');
    this.newMedicine.doctorId = doctor.id;
    if (doctor.id) {
      this.loadMedicines(doctor.id);
    }
  }

  loadMedicines(doctorId: number) {
    this.medicineService.getMedicinesByDoctorId(doctorId).subscribe({
      next: (data: any) => this.medicines = data || []
    });
  }

  addMedicine() {
    this.medicineService.addMedicine(this.newMedicine).subscribe({
      next: () => {
        this.successMsg = 'Medicine added!';
        this.errorMsg = '';
        this.loadMedicines(this.newMedicine.doctorId);
        this.newMedicine = { medicineName: '', type: 'Tablet', doctorId: this.newMedicine.doctorId };
        setTimeout(() => this.successMsg = '', 3000);
      },
      error: (err: any) => { this.errorMsg = err.error?.message || 'Failed to add.'; this.successMsg = ''; }
    });
  }

  deleteMedicine(id: number) {
    if (confirm('Delete this medicine?')) {
      this.medicineService.deleteMedicine(id).subscribe({
        next: () => this.medicines = this.medicines.filter(m => m.id !== id)
      });
    }
  }
}

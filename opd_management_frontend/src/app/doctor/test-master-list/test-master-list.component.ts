import { Component, OnInit } from '@angular/core';
import { TestMasterService } from '../../services/test-master.service';

@Component({
  selector: 'app-test-master-list',
  templateUrl: './test-master-list.component.html',
  styleUrls: ['./test-master-list.component.css']
})
export class TestMasterListComponent implements OnInit {
  testMasters: any[] = [];
  newTestMaster: any = { testName: '', unit: '', normalRange: '', doctorId: 0 };
  successMsg = '';
  errorMsg = '';

  constructor(private testMasterService: TestMasterService) {}

  ngOnInit(): void {
    const doctor = JSON.parse(localStorage.getItem('doctor') || '{}');
    this.newTestMaster.doctorId = doctor.id;
    if (doctor.id) {
      this.loadTestMasters(doctor.id);
    }
  }

  loadTestMasters(doctorId: number) {
    this.testMasterService.getTestMastersByDoctorId(doctorId).subscribe({
      next: (data: any) => this.testMasters = data || []
    });
  }

  addTestMaster() {
    this.testMasterService.addTestMaster(this.newTestMaster).subscribe({
      next: () => {
        this.successMsg = 'Test Master added!';
        this.errorMsg = '';
        this.loadTestMasters(this.newTestMaster.doctorId);
        this.newTestMaster = { testName: '', unit: '', normalRange: '', doctorId: this.newTestMaster.doctorId };
        setTimeout(() => this.successMsg = '', 3000);
      },
      error: (err: any) => {
        this.errorMsg = err.error?.message || 'Failed to add.';
        this.successMsg = '';
      }
    });
  }

  deleteTestMaster(id: number) {
    if (confirm('Delete this test master?')) {
      this.testMasterService.deleteTestMaster(id).subscribe({
        next: () => this.testMasters = this.testMasters.filter(t => t.id !== id)
      });
    }
  }
}

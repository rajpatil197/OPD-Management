import { Component, OnInit } from '@angular/core';
import { ReferralCenterService } from '../../services/referral-center.service';

@Component({
  selector: 'app-referral-center-list',
  templateUrl: './referral-center-list.component.html',
  styleUrls: ['./referral-center-list.component.css']
})
export class ReferralCenterListComponent implements OnInit {
  referralCenters: any[] = [];
  newReferralCenter: any = {
    name: '',
    type: 'Hospital',
    address: '',
    contactInfo: '',
    doctorId: 0
  };
  successMsg = '';
  errorMsg = '';

  constructor(private referralCenterService: ReferralCenterService) {}

  ngOnInit(): void {
    const doctor = JSON.parse(localStorage.getItem('doctor') || '{}');
    this.newReferralCenter.doctorId = doctor.id;
    if (doctor.id) {
      this.loadReferralCenters(doctor.id);
    }
  }

  loadReferralCenters(doctorId: number) {
    this.referralCenterService.getReferralCentersByDoctorId(doctorId).subscribe({
      next: (data: any) => this.referralCenters = data || []
    });
  }

  addReferralCenter() {
    this.referralCenterService.addReferralCenter(this.newReferralCenter).subscribe({
      next: () => {
        this.successMsg = 'Referral Center added!';
        this.errorMsg = '';
        this.loadReferralCenters(this.newReferralCenter.doctorId);
        this.newReferralCenter = {
          name: '',
          type: 'Hospital',
          address: '',
          contactInfo: '',
          doctorId: this.newReferralCenter.doctorId
        };
        setTimeout(() => this.successMsg = '', 3000);
      },
      error: (err: any) => {
        this.errorMsg = err.error?.message || 'Failed to add.';
        this.successMsg = '';
      }
    });
  }

  deleteReferralCenter(id: number) {
    if (confirm('Delete this referral center?')) {
      this.referralCenterService.deleteReferralCenter(id).subscribe({
        next: () => this.referralCenters = this.referralCenters.filter(c => c.id !== id)
      });
    }
  }
}

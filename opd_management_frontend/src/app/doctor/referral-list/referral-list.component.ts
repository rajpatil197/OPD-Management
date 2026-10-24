import { Component, Input, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { ReferralService } from '../../services/referral.service';
import { ReferralCenterService } from '../../services/referral-center.service';

@Component({
  selector: 'app-referral-list',
  templateUrl: './referral-list.component.html',
  styleUrls: ['./referral-list.component.css']
})
export class ReferralListComponent implements OnInit, OnChanges {
  @Input() visitId: number = 0;
  @Input() patientId: number = 0;

  referrals: any[] = [];
  referralCenters: any[] = [];
  newReferral: any = {
    visitId: 0,
    patientId: 0,
    doctorId: 0,
    referralCenterId: '',
    reason: '',
    noteType: 'Referral Note',
    deatils: ''
  };
  successMsg = '';
  errorMsg = '';

  constructor(
    private referralService: ReferralService,
    private referralCenterService: ReferralCenterService
  ) {}

  ngOnInit(): void {
    const doctor = JSON.parse(localStorage.getItem('doctor') || '{}');
    this.newReferral.doctorId = doctor.id;
    this.newReferral.visitId = this.visitId;
    this.newReferral.patientId = this.patientId;
    if (doctor.id) {
      this.loadReferralCenters(doctor.id);
    }
    if (this.visitId) {
      this.loadReferrals();
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['visitId'] && this.visitId) {
      this.newReferral.visitId = this.visitId;
      this.loadReferrals();
    }
    if (changes['patientId'] && this.patientId) {
      this.newReferral.patientId = this.patientId;
    }
  }

  loadReferralCenters(doctorId: number) {
    this.referralCenterService.getReferralCentersByDoctorId(doctorId).subscribe({
      next: (data: any) => this.referralCenters = data || []
    });
  }

  loadReferrals() {
    if (!this.visitId) return;
    this.referralService.getReferralsByVisitId(this.visitId).subscribe({
      next: (data: any) => this.referrals = data || []
    });
  }

  addReferral() {
    this.newReferral.visitId = this.visitId;
    this.newReferral.patientId = this.patientId;
    const payload = {
      ...this.newReferral,
      details: this.newReferral.deatils
    };
    this.referralService.addReferral(payload).subscribe({
      next: () => {
        this.successMsg = 'Referral added successfully!';
        this.errorMsg = '';
        this.loadReferrals();
        this.newReferral = {
          visitId: this.visitId,
          patientId: this.patientId,
          doctorId: this.newReferral.doctorId,
          referralCenterId: '',
          reason: '',
          noteType: 'Referral Note',
          deatils: ''
        };
        setTimeout(() => this.successMsg = '', 3000);
      },
      error: (err: any) => {
        this.errorMsg = err.error?.message || 'Failed to add referral.';
        this.successMsg = '';
      }
    });
  }

  deleteReferral(id: number) {
    if (confirm('Delete this referral?')) {
      this.referralService.deleteReferral(id).subscribe({
        next: () => this.referrals = this.referrals.filter(r => r.id !== id)
      });
    }
  }
}

import { Component, Input, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { PathologyTestService } from '../../services/pathology-test.service';
import { TestMasterService } from '../../services/test-master.service';

@Component({
  selector: 'app-pathology-test-list',
  templateUrl: './pathology-test-list.component.html',
  styleUrls: ['./pathology-test-list.component.css']
})
export class PathologyTestListComponent implements OnInit, OnChanges {
  @Input() visitId: number = 0;
  pathologyTests: any[] = [];
  testMasters: any[] = [];
  newTest: any = {
    visitId: 0,
    testMasterId: '',
    result: '',
    remarks: '',
    reportFile: ''
  };
  successMsg = '';
  errorMsg = '';

  constructor(
    private pathologyTestService: PathologyTestService,
    private testMasterService: TestMasterService
  ) {}

  ngOnInit(): void {
    const doctor = JSON.parse(localStorage.getItem('doctor') || '{}');
    this.newTest.visitId = this.visitId;
    if (doctor.id) {
      this.loadTestMasters(doctor.id);
    }
    if (this.visitId) {
      this.loadPathologyTests();
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['visitId'] && this.visitId) {
      this.newTest.visitId = this.visitId;
      this.loadPathologyTests();
    }
  }

  loadTestMasters(doctorId: number) {
    this.testMasterService.getTestMastersByDoctorId(doctorId).subscribe({
      next: (data: any) => this.testMasters = data || []
    });
  }

  loadPathologyTests() {
    if (!this.visitId) return;
    this.pathologyTestService.getPathologyTestsByVisitId(this.visitId).subscribe({
      next: (data: any) => this.pathologyTests = data || []
    });
  }

  addPathologyTest() {
    this.newTest.visitId = this.visitId;
    this.pathologyTestService.addPathologyTest(this.newTest).subscribe({
      next: () => {
        this.successMsg = 'Pathology test added successfully!';
        this.errorMsg = '';
        this.loadPathologyTests();
        this.newTest = {
          visitId: this.visitId,
          testMasterId: '',
          result: '',
          remarks: '',
          reportFile: ''
        };
        setTimeout(() => this.successMsg = '', 3000);
      },
      error: (err: any) => {
        this.errorMsg = err.error?.message || 'Failed to add pathology test.';
        this.successMsg = '';
      }
    });
  }

  deletePathologyTest(id: number) {
    if (confirm('Delete this test?')) {
      this.pathologyTestService.deletePathologyTest(id).subscribe({
        next: () => this.pathologyTests = this.pathologyTests.filter(t => t.id !== id)
      });
    }
  }
}

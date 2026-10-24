import { Component, Input, OnInit } from '@angular/core';
import { VisitReportService } from '../../services/visit-report.service';

@Component({
  selector: 'app-visit-report-list',
  templateUrl: './visit-report-list.component.html',
  styleUrls: ['./visit-report-list.component.css']
})
export class VisitReportListComponent implements OnInit {
  @Input() visitId: number = 0;
  reports: any[] = [];
  newReport: any = {
    visitId: 0,
    fileName: '',
    fileType: 'PDF',
    fileUrl: ''
  };
  successMsg = '';
  errorMsg = '';
  showForm = false;

  constructor(private visitReportService: VisitReportService) {}

  ngOnInit(): void {
    this.newReport.visitId = this.visitId;
    if (this.visitId) {
      this.loadReports();
    }
  }

  loadReports(): void {
    this.visitReportService.getVisitReportsByVisitId(this.visitId).subscribe({
      next: (data: any) => {
        this.reports = (data || []).map((r: any) => ({
          ...r,
          fileName: r.fileName || r.file_name,
          fileType: r.fileType || r.file_type,
          fileUrl: r.fileUrl || r.file_url
        }));
      },
      error: (err: any) => console.error('Failed to load reports', err)
    });
  }

  addReport(): void {
    this.newReport.visitId = this.visitId;
    this.visitReportService.addVisitReport(this.newReport).subscribe({
      next: () => {
        this.successMsg = 'Report added successfully!';
        this.showForm = false;
        this.loadReports();
        this.resetForm();
        setTimeout(() => this.successMsg = '', 3000);
      },
      error: (err: any) => {
        this.errorMsg = err.error?.message || 'Failed to add report.';
        setTimeout(() => this.errorMsg = '', 4000);
      }
    });
  }

  deleteReport(id: number): void {
    if (confirm('Delete this report?')) {
      this.visitReportService.deleteVisitReport(id).subscribe({
        next: () => {
          this.reports = this.reports.filter(r => r.id !== id);
        },
        error: (err: any) => alert('Failed to delete report.')
      });
    }
  }

  resetForm(): void {
    this.newReport = {
      visitId: this.visitId,
      fileName: '',
      fileType: 'PDF',
      fileUrl: ''
    };
  }
}

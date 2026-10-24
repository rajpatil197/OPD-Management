import { Component, Input, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { DiagnosticService } from '../../services/diagnostic.service';

@Component({
  selector: 'app-diagnostic-list',
  templateUrl: './diagnostic-list.component.html',
  styleUrls: ['./diagnostic-list.component.css']
})
export class DiagnosticListComponent implements OnInit, OnChanges {
  @Input() visitId: number = 0;
  diagnostics: any[] = [];
  newDiagnostic: any = { name: '', visitId: 0, doctorId: 0 };
  successMsg = '';
  errorMsg = '';

  constructor(private diagnosticService: DiagnosticService) {}

  ngOnInit(): void {
    const doctor = JSON.parse(localStorage.getItem('doctor') || '{}');
    this.newDiagnostic.doctorId = doctor.id;
    this.newDiagnostic.visitId = this.visitId;
    if (this.visitId) {
      this.loadDiagnostics();
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['visitId'] && this.visitId) {
      this.newDiagnostic.visitId = this.visitId;
      this.loadDiagnostics();
    }
  }

  loadDiagnostics() {
    if (!this.visitId) return;
    this.diagnosticService.getDiagnosticsByVisitId(this.visitId).subscribe({
      next: (data: any) => this.diagnostics = data || []
    });
  }

  addDiagnostic() {
    this.newDiagnostic.visitId = this.visitId;
    this.diagnosticService.addDiagnostic(this.newDiagnostic).subscribe({
      next: () => {
        this.successMsg = 'Diagnostic added!';
        this.loadDiagnostics();
        this.newDiagnostic = { name: '', visitId: this.visitId, doctorId: this.newDiagnostic.doctorId };
        setTimeout(() => this.successMsg = '', 3000);
      },
      error: (err: any) => this.errorMsg = err.error?.message || 'Failed.'
    });
  }

  deleteDiagnostic(id: number) {
    if (confirm('Delete?')) {
      this.diagnosticService.deleteDiagnostic(id).subscribe({
        next: () => this.diagnostics = this.diagnostics.filter(d => d.id !== id)
      });
    }
  }
}

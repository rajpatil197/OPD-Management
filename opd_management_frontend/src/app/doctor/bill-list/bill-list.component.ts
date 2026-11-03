import { Component, Input, OnInit } from '@angular/core';
import { BillService } from '../../services/bill.service';

@Component({
  selector: 'app-bill-list',
  templateUrl: './bill-list.component.html',
  styleUrls: ['./bill-list.component.css']
})
export class BillListComponent implements OnInit {
  @Input() visitId: number = 0;
  bills: any[] = [];
  newBill: any = {
    visitId: 0, consultationFee: '', totalAmount: '', paidAmount: '',
    pendingAmount: '', concession: '', paymentMode: 'Cash', paymentStatus: 'Pending'
  };
  successMsg = '';
  errorMsg = '';
  showForm = false;

  constructor(private billService: BillService) {}

  ngOnInit(): void {
    this.newBill.visitId = this.visitId;
    if (this.visitId) this.loadBills();
  }

  loadBills() {
    this.billService.getBillsByVisitId(this.visitId).subscribe({
      next: (data: any) => this.bills = data
    });
  }

  addBill() {
    this.newBill.visitId = this.visitId;
    this.billService.addBill(this.newBill).subscribe({
      next: () => {
        this.successMsg = 'Bill added!';
        this.showForm = false;
        this.loadBills();
        this.resetForm();
        setTimeout(() => this.successMsg = '', 3000);
      },
      error: (err: any) => this.errorMsg = err.error?.message || 'Failed.'
    });
  }

  deleteBill(id: number) {
    if (confirm('Delete this bill?')) {
      this.billService.deleteBill(id).subscribe({
        next: () => this.bills = this.bills.filter(b => b.id !== id)
      });
    }
  }

  resetForm() {
    this.newBill = {
      visitId: this.visitId, consultationFee: '', totalAmount: '', paidAmount: '',
      pendingAmount: '', concession: '', paymentMode: 'Cash', paymentStatus: 'Pending'
    };
  }
}

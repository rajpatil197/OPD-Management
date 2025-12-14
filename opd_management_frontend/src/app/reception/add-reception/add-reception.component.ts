import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ReceptionService } from 'src/app/services/reception-service.service';


@Component({
  selector: 'app-add-reception',
  templateUrl: './add-reception.component.html',
  styleUrls: ['./add-reception.component.css']
})
export class AddReceptionComponent {

  reception = {
    name: '',
    email: '',
    phoneNo: '',
    shift: '',
    password: '',
    doctorid: 0
  };

  constructor(
    private receptionService: ReceptionService,
    private router: Router
  ) {
    const doctor = JSON.parse(localStorage.getItem('doctor')!);
    this.reception.doctorid = doctor.id;   // ✅ auto assign doctor
  }

  saveReception() {
    this.receptionService.addReception(this.reception).subscribe({
      next: () => {
        alert('Reception registered successfully');
        this.router.navigate(['/doctor/reception-list']);
      },
      error: (err) => {
        console.error(err);
        alert('Failed to register reception');
      }
    });
  }
}

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
    const doctorStr = localStorage.getItem('doctor');

    if (!doctorStr) {
      alert('Doctor not logged in');
      return;
    }

    const doctorObj = JSON.parse(doctorStr);

    // CORRECT KEY
    this.reception.doctorid = doctorObj.doctorId;
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

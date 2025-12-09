import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-doctor-layout',
  templateUrl: './doctor-layout.component.html',
  styleUrls: ['./doctor-layout.component.css']
})
export class DoctorLayoutComponent implements OnInit {

  doctor: any = null;

  ngOnInit() {
    const storedDoctor = localStorage.getItem("doctor");
    if (storedDoctor) {
      this.doctor = JSON.parse(storedDoctor);
    }
  }

  logout() {
    localStorage.clear();
    window.location.href = "/login";
  }
}

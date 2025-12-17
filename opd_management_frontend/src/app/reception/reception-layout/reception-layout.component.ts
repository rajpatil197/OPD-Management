import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reception-layout',
  templateUrl: './reception-layout.component.html',
  styleUrls: ['./reception-layout.component.css']
})
export class ReceptionLayoutComponent implements OnInit{

  reception :any =null;

  constructor(private router: Router) {}

  ngOnInit(): void {
      const storedreception = localStorage.getItem("reception");
      if(storedreception){
        this.reception = JSON.parse(storedreception);
      }
  }
  

  logout() {
    localStorage.removeItem('reception');
    localStorage.removeItem('receptionId');
    this.router.navigate(['/reception-login']);
  }
}

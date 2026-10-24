import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VisitService } from 'src/app/services/visit-service.service';

@Component({
  selector: 'app-visit-details',
  templateUrl: './visit-details.component.html',
  styleUrls: ['./visit-details.component.css']
})
export class VisitDetailsComponent implements OnInit{

  visit:any ={};
  visitId:number=0;

  constructor(private route:ActivatedRoute,private visitService:VisitService,private router:Router){}

  ngOnInit(): void {
    
    this.visitId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadvisit();
  }

  loadvisit(){
    this.visitService.getVisitById(this.visitId).subscribe({
      next: (res)=>{
        console.log("Visit Response:",res);
        
        this.visit = res;
      },
      error:() => alert("Failed to load visit")
    });
  }

  saveVisit(){
    const payload ={
      ...this.visit,
      doctorid: this.visit.doctorid?.id,
      patientid: this.visit.patientid?.id,
    };
    console.log("Sending Payload",payload);
    
    this.visitService.updateVisit(this.visitId,payload).subscribe({
      next:() => {
        alert("visit updated succesfully");
        this.router.navigate(['/doctor/visit-list']);
      },
      error:(err) =>{
        console.log(err);
        alert("error saving visit") 
      }
    });
  }

}

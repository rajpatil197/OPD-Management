import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VisitService } from 'src/app/services/visit-service.service';

@Component({
  selector: 'app-visit-details',
  templateUrl: './visit-details.component.html',
  styleUrls: ['./visit-details.component.css']
})
export class VisitDetailsComponent implements OnInit{

  visit:any ={};
  visitId:number=0;

  constructor(private route:ActivatedRoute,private visitService:VisitService){}

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
     this.visitService.updateVisit(this.visitId,this.visit).subscribe({
      next:()=> alert("Visit is updated Succesfully"),
      error:()=>alert("Error saving Visit")
     });
  }


}

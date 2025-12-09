import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { DoctorRegisterComponent } from './doctor-register/doctor-register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { DoctorLayoutComponent } from './layout/doctor-layout/doctor-layout.component';
import { authGuard } from './auth.guard';


const routes: Routes = [

  // PAGES WITHOUT SIDEBAR
  { path: "", component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "doctorregister", component: DoctorRegisterComponent },

  // PAGES WITH SIDEBAR (dashboard routes)
  {
    path: "",
    component: DoctorLayoutComponent,
    canActivate: [authGuard],
    children: [
      { path: "dashboard", component: DashboardComponent },
      { path: "patients", component: PatientListComponent },
      { path: "add-patient", component: AddPatientComponent }
    ]
  }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

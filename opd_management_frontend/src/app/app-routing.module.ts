import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { DoctorRegisterComponent } from './doctor-register/doctor-register.component';

import { DashboardComponent } from './dashboard/dashboard.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { AddPatientComponent } from './reception/add-patient/add-patient.component';

import { DoctorLayoutComponent } from './layout/doctor-layout/doctor-layout.component';
import { authGuard } from './auth.guard';

import { ReceptionLoginComponent } from './reception/reception-login/reception-login.component';
import { ReceptionDashboardComponent } from './reception/reception-dashboard/reception-dashboard.component';
import { ReceptionListComponent } from './reception/reception-list/reception-list.component';
import { AddReceptionComponent } from './reception/add-reception/add-reception.component';

import { ReceptionAuthGuard } from './guards/reception-auth.guard';
import { ReceptionLayoutComponent } from './reception/reception-layout/reception-layout.component';
import { EditPatientComponent } from './reception/edit-patient/edit-patient.component';
import { CreateVisitComponent } from './reception/create-visit/create-visit.component';
import { VisitListComponent } from './doctor/visit-list/visit-list.component';
import { VisitDetailsComponent } from './doctor/visit-details/visit-details.component';
import { PatientVisitsComponent } from './reception/patient-visits/patient-visits.component';
import { MedicineListComponent } from './doctor/medicine-list/medicine-list.component';
import { TestMasterListComponent } from './doctor/test-master-list/test-master-list.component';
import { ReferralCenterListComponent } from './doctor/referral-center-list/referral-center-list.component';

const routes: Routes = [

  // ---------------- PUBLIC ROUTES ----------------
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'doctorregister', component: DoctorRegisterComponent },
  { path: 'reception-login', component: ReceptionLoginComponent },
  { path: 'reception-register', component: AddReceptionComponent },

  // ---------------- DOCTOR PANEL ----------------
  {
    path: 'doctor',
    component: DoctorLayoutComponent,
    canActivate: [authGuard],
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'patients', component: PatientListComponent },
      { path: 'patient-visits/:id', component: PatientVisitsComponent },
      { path: 'reception-list', component: ReceptionListComponent },
      { path: 'add-reception', component: AddReceptionComponent },
      { path: 'edit-patient/:id', component: EditPatientComponent },
      { path: 'visit-list', component: VisitListComponent },
      { path: 'visit/:id', component: VisitDetailsComponent },
      { path: 'medicines', component: MedicineListComponent },
      { path: 'test-masters', component: TestMasterListComponent },
      { path: 'referral-centers', component: ReferralCenterListComponent }
    ]
  },

  // ---------------- RECEPTION PANEL ----------------
  {
    path: 'reception',
    component: ReceptionLayoutComponent,
    canActivate: [ReceptionAuthGuard],
    children: [
      { path: 'dashboard', component: ReceptionDashboardComponent },
      { path: 'patients', component: PatientListComponent },
      { path: 'patient-visits/:id', component: PatientVisitsComponent },
      { path: 'add-patient', component: AddPatientComponent },
      { path: 'edit-patient/:id', component: EditPatientComponent },
      { path: 'create-visit', component: CreateVisitComponent },
      { path: 'add-reception', component: AddReceptionComponent },
      { path: 'reception-list', component: ReceptionListComponent }
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

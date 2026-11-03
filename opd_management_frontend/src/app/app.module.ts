import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { DoctorRegisterComponent } from './doctor-register/doctor-register.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { AddPatientComponent } from './reception/add-patient/add-patient.component';
import { DoctorLayoutComponent } from './layout/doctor-layout/doctor-layout.component';
import { ReceptionListComponent } from './reception/reception-list/reception-list.component';
import { AddReceptionComponent } from './reception/add-reception/add-reception.component';
import { ReceptionLoginComponent } from './reception/reception-login/reception-login.component';
import { ReceptionDashboardComponent } from './reception/reception-dashboard/reception-dashboard.component';
import { ReceptionLayoutComponent } from './reception/reception-layout/reception-layout.component';
import { EditPatientComponent } from './reception/edit-patient/edit-patient.component';
import { CreateVisitComponent } from './reception/create-visit/create-visit.component';
import { VisitListComponent } from './doctor/visit-list/visit-list.component';
import { VisitDetailsComponent } from './doctor/visit-details/visit-details.component';
import { BillListComponent } from './doctor/bill-list/bill-list.component';
import { VisitReportListComponent } from './doctor/visit-report-list/visit-report-list.component';
import { PatientVisitsComponent } from './reception/patient-visits/patient-visits.component';
import { MedicineListComponent } from './doctor/medicine-list/medicine-list.component';
import { TestMasterListComponent } from './doctor/test-master-list/test-master-list.component';
import { ReferralCenterListComponent } from './doctor/referral-center-list/referral-center-list.component';
import { DiagnosticListComponent } from './doctor/diagnostic-list/diagnostic-list.component';
import { PathologyTestListComponent } from './doctor/pathology-test-list/pathology-test-list.component';
import { ReferralListComponent } from './doctor/referral-list/referral-list.component';
import { AuthInterceptor } from './auth.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    DoctorRegisterComponent,
    DashboardComponent,
    PatientListComponent,
    AddPatientComponent,
    DoctorLayoutComponent,
    ReceptionListComponent,
    AddReceptionComponent,
    ReceptionLoginComponent,
    ReceptionDashboardComponent,
    ReceptionLayoutComponent,
    EditPatientComponent,
    CreateVisitComponent,
    VisitListComponent,
    VisitDetailsComponent,
    BillListComponent,
    VisitReportListComponent,
    PatientVisitsComponent,
    MedicineListComponent,
    TestMasterListComponent,
    ReferralCenterListComponent,
    DiagnosticListComponent,
    PathologyTestListComponent,
    ReferralListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

  ],
   providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

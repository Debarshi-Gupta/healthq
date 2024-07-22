import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { HospitalsComponent } from './components/hospitals/hospitals.component';
import { AuthGuardService } from './services/auth.guard.service';
import { CreatehospitalComponent } from './components/createhospital/createhospital.component';
import { UpdatehospitalComponent } from './components/updatehospital/updatehospital.component';
import { TestsComponent } from './components/tests/tests.component';
import { CreatetestComponent } from './components/createtest/createtest.component';
import { UpdatetestComponent } from './components/updatetest/updatetest.component';
import { PlansComponent } from './components/plans/plans.component';
import { CreateplanComponent } from './components/createplan/createplan.component';
import { UpdateplanComponent } from './components/updateplan/updateplan.component';
import { HomeComponent } from './components/home/home.component';
import { SearchhospitalsComponent } from './components/searchhospitals/searchhospitals.component';
import { MemberregistrationComponent } from './components/memberregistration/memberregistration.component';
import { MembervalidationComponent } from './components/membervalidation/membervalidation.component';
import { MemberdetailsComponent } from './components/memberdetails/memberdetails.component';
import { MemberdetailsupdateComponent } from './components/memberdetailsupdate/memberdetailsupdate.component';


const routes: Routes = [
  {
    path:"login",
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:"dashboard",
    component:DashboardComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"hospitals",
    component:HospitalsComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"createhospital",
    component:CreatehospitalComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"updatehospital",
    component:UpdatehospitalComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"tests",
    component:TestsComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"createtest",
    component:CreatetestComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"updatetest",
    component:UpdatetestComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"plans",
    component:PlansComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"createplan",
    component:CreateplanComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"updateplan",
    component:UpdateplanComponent,
    pathMatch:'full',
    canActivate:[AuthGuardService]
  },
  {
    path:"home",
    component:HomeComponent,
    pathMatch:'full'
  },
  {
    path:"searchhospitals",
    component:SearchhospitalsComponent,
    pathMatch:'full'
  },
  {
    path:"memberregistration",
    component:MemberregistrationComponent,
    pathMatch:'full'
  },
  {
    path:"membervalidation",
    component:MembervalidationComponent,
    pathMatch:'full'
  },
  {
    path:"memberdetails",
    component:MemberdetailsComponent,
    pathMatch:'full'
  },
  {
    path:"memberdetailsupdate",
    component:MemberdetailsupdateComponent,
    pathMatch:'full'
  },
  {
    path:"",
    component:HomeComponent,
    pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginService } from './services/login.service';
import { AuthGuardService } from './services/auth.guard.service';
import { AuthInterceptor } from './services/auth.intercepter';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatListModule } from '@angular/material/list';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDialogModule } from '@angular/material/dialog';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HospitalsComponent } from './components/hospitals/hospitals.component';
import { CreatehospitalComponent } from './components/createhospital/createhospital.component';
import { UpdatehospitalComponent } from './components/updatehospital/updatehospital.component';
import { TestsComponent } from './components/tests/tests.component';
import { CreatetestComponent } from './components/createtest/createtest.component';
import { UpdatetestComponent } from './components/updatetest/updatetest.component';
import { PlansComponent } from './components/plans/plans.component';
import { CreateplanComponent } from './components/createplan/createplan.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { UpdateplanComponent } from './components/updateplan/updateplan.component';
import { NameFilter } from './services/NameFilter';
import { LocationFilter } from './services/LocationFilter';
import { HomeComponent } from './components/home/home.component';
import { SearchhospitalsComponent } from './components/searchhospitals/searchhospitals.component';
import { MemberregistrationComponent } from './components/memberregistration/memberregistration.component';
import { MemberregistrationdialogComponent } from './components/memberregistrationdialog/memberregistrationdialog.component';
import { MembervalidationComponent } from './components/membervalidation/membervalidation.component';
import { MemberdetailsComponent } from './components/memberdetails/memberdetails.component';
import { MemberdetailsupdateComponent } from './components/memberdetailsupdate/memberdetailsupdate.component';
import { MemberdetailsupdatedialogComponent } from './components/memberdetailsupdatedialog/memberdetailsupdatedialog.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    NavbarComponent,
    HospitalsComponent,
    CreatehospitalComponent,
    UpdatehospitalComponent,
    TestsComponent,
    CreatetestComponent,
    UpdatetestComponent,
    PlansComponent,
    CreateplanComponent,
    UpdateplanComponent,
    NameFilter,
    LocationFilter,
    HomeComponent,
    SearchhospitalsComponent,
    MemberregistrationComponent,
    MemberregistrationdialogComponent,
    MembervalidationComponent,
    MemberdetailsComponent,
    MemberdetailsupdateComponent,
    MemberdetailsupdatedialogComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatMenuModule,
    MatExpansionModule,
    MatListModule,
    MatSelectModule,
    NgMultiSelectDropDownModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatDialogModule,
    NgbModule
  ],
  providers: [LoginService, AuthGuardService,[{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }

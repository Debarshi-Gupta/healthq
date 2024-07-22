import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HospitalsService } from 'src/app/services/hospitals.service';

@Component({
  selector: 'app-createhospital',
  templateUrl: './createhospital.component.html',
  styleUrls: ['./createhospital.component.css']
})
export class CreatehospitalComponent implements OnInit {

  constructor(private hospitalsService:HospitalsService, private router:Router) { }

  hospital=
  {
    id: '',
    addressId: '',
    hospitalName: '',
    appointmentsPerDay: '',
    contactNumber: '',
    emailId: ''
  };

  hospitalAddress=
  {
    id: '',
    streetLine1: '',
    streetLine2: '',
    location: '',
    pincode: '',
    state: '',
    country: ''
  };

  formEmpty = false;

  ngOnInit(): void {
  }

  onSubmit()
  {
    if(this.hospital.hospitalName!='' && this.hospital.appointmentsPerDay!='' && this.hospital.contactNumber!='' && this.hospitalAddress.streetLine1!='' && this.hospitalAddress.location!='' && this.hospitalAddress.pincode!='' && this.hospitalAddress.state!='' && this.hospitalAddress.country!='')
    { this.hospitalsService.createHospital(this.hospital,this.hospitalAddress).subscribe(
        response=>{
          console.log(response);
          this.router.navigate(['hospitals']);
        }
      )
    }
    else
    {
      this.formEmpty = true;
    }
  }

}

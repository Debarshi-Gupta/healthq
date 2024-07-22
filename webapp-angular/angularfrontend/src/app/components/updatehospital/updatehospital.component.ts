import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HospitalsService } from 'src/app/services/hospitals.service';

@Component({
  selector: 'app-updatehospital',
  templateUrl: './updatehospital.component.html',
  styleUrls: ['./updatehospital.component.css']
})
export class UpdatehospitalComponent implements OnInit {

  constructor(private hospitalsService:HospitalsService, private router:Router) { }

  updateHospitalMap = this.hospitalsService.updateHospitalMap;

  hospital=
  {
    id: '',
    //addressId: '',
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

  formEmpty=false;

  ngOnInit(): void {
    this.hospital.id = this.updateHospitalMap.hospital.id;
    //this.hospital.addressId = this.updateHospitalMap.hospital.addressId;
    this.hospital.hospitalName = this.updateHospitalMap.hospital.hospitalName;
    this.hospital.appointmentsPerDay = this.updateHospitalMap.hospital.appointmentsPerDay;
    this.hospital.contactNumber = this.updateHospitalMap.hospital.contactNumber;
    this.hospital.emailId = this.updateHospitalMap.hospital.emailId;

    this.hospitalAddress.id = this.updateHospitalMap.hospitalAddress.id;
    this.hospitalAddress.streetLine1 = this.updateHospitalMap.hospitalAddress.streetLine1;
    this.hospitalAddress.streetLine2 = this.updateHospitalMap.hospitalAddress.streetLine2;
    this.hospitalAddress.location = this.updateHospitalMap.hospitalAddress.location;
    this.hospitalAddress.pincode = this.updateHospitalMap.hospitalAddress.pincode;
    this.hospitalAddress.state = this.updateHospitalMap.hospitalAddress.state;
    this.hospitalAddress.country = this.updateHospitalMap.hospitalAddress.country;
  }

  onSubmit()
  {
    if(this.hospital.hospitalName!='' && this.hospital.appointmentsPerDay!='' && this.hospital.contactNumber!='' && this.hospitalAddress.streetLine1!='' && this.hospitalAddress.location!='' && this.hospitalAddress.pincode!='' && this.hospitalAddress.state!='' && this.hospitalAddress.country!='')
    { 
      this.hospitalsService.updateHospital(this.hospital,this.hospitalAddress).subscribe(
        response=>{
          console.log(response);
          this.router.navigate(['hospitals']);
        }
      )
    }
    else 
    {
      this.formEmpty=true;
    }

  }
}

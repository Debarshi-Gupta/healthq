import { identifierName } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { HospitalsService } from 'src/app/services/hospitals.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hospitals',
  templateUrl: './hospitals.component.html',
  styleUrls: ['./hospitals.component.css']
})
export class HospitalsComponent implements OnInit {

  hospitalInformationList: any;

  constructor(private hospitalsService:HospitalsService, private router:Router) { }

  ngOnInit(): void {

    this.hospitalsService.getAllHospitalInformation().subscribe(
      (response:any)=>{
        this.hospitalInformationList=response;
        console.log(this.hospitalInformationList);
      }
    )
  }

  getCreateHospital()
  {
    this.router.navigate(['createhospital']);
  }

  getUpdatehospital(list:any)
  {
    this.hospitalsService.updateHospitalMap=list;
    this.router.navigate(['updatehospital']);
  }

  deleteHospital(list:any)
  {
    this.hospitalsService.deleteHospital(list.hospital, list.hospitalAddress).subscribe(
      response=>{
        console.log(response);
        location.reload();
      }
    )
  }



}

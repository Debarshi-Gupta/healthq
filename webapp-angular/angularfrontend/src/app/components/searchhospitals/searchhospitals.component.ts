import { Component, OnInit } from '@angular/core';
import { HospitalsService } from 'src/app/services/hospitals.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-searchhospitals',
  templateUrl: './searchhospitals.component.html',
  styleUrls: ['./searchhospitals.component.css']
})
export class SearchhospitalsComponent implements OnInit {

  hospitalInformationList: any;

  searchText= '';

  filter= 'Hospital Name';

  constructor(private hospitalsService:HospitalsService, private router:Router) { }

  ngOnInit(): void {

    this.hospitalsService.searchAllHospitalInformation().subscribe(
      (response:any)=>{
        this.hospitalInformationList=response;
        console.log(this.hospitalInformationList);
      }
    )
  }

  getMemberRegistration()
  {
    this.router.navigate(['memberregistration']);
  }

}

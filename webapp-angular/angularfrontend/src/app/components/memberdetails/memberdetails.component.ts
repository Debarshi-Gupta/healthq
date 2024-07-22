import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HospitalsService } from 'src/app/services/hospitals.service';
import { MembersService } from 'src/app/services/members.service';
import { PlansService } from 'src/app/services/plans.service';

@Component({
  selector: 'app-memberdetails',
  templateUrl: './memberdetails.component.html',
  styleUrls: ['./memberdetails.component.css']
})
export class MemberdetailsComponent implements OnInit {

  constructor(private membersService:MembersService, private plansService:PlansService, private hospitalsService:HospitalsService, private router:Router) { }

  memberDetails = this.membersService.memberDetails;

  allPlansList: Array<any> = [];
  planName = '';

  appointmentSlot = this.memberDetails.appointmentDateHour;
  appointmentSlot2 = this.memberDetails.appointmentDateHour+1;

  allHospitalList: any;
  hospitalName = '';

  ngOnInit(): void {

    this.memberDetails = this.membersService.memberDetails;

    console.log(this.memberDetails);

    this.plansService.searchAllPlans().subscribe(
      (response:any)=>
      {
        this.allPlansList = response;
        console.log(this.allPlansList);

        for(let planWrapper of this.allPlansList)
        {
          if(this.memberDetails.planId==planWrapper.plan.id)
          {
            this.planName = planWrapper.plan.planName;
          }
        }
      }
    );

    this.hospitalsService.searchAllHospitalInformation().subscribe(
      (response:any)=>
      {
        this.allHospitalList = response;
        console.log(this.allHospitalList);

        for(let hospitalMap of this.allHospitalList)
        {
          if(this.memberDetails.hospitalId==hospitalMap.hospital.id)
          {
            this.hospitalName = hospitalMap.hospital.hospitalName;
          }
        }
      }
    );  
  }

  getMemberDetailsUpdate()
  {
    this.router.navigate(['memberdetailsupdate']);
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MembersService } from 'src/app/services/members.service';
import { HospitalsService } from 'src/app/services/hospitals.service';
import { PlansService } from 'src/app/services/plans.service';
import { MatDialog } from '@angular/material/dialog';
import { MemberregistrationdialogComponent } from '../memberregistrationdialog/memberregistrationdialog.component';

@Component({
  selector: 'app-memberregistration',
  templateUrl: './memberregistration.component.html',
  styleUrls: ['./memberregistration.component.css']
})
export class MemberregistrationComponent implements OnInit {

  id = '';

  address = '';

  name = '';

  gender = '';

  dob = new Date();
  dobDay = '';
  dobMonth = '';
  dobYear = '';

  contactNumber = '';

  emailId = '';

  allPlansList: any;
  planId = '';
  planCost = 0;

  appointmentDate = new Date();
  appointmentDateDay = '';
  appointmentDateMonth = '';
  appointmentDateYear = '';
  appointmentDateHour = '';

  allHospitalMapList: any;
  hospitalId = '';

  allMembersList: any;

  formEmpty = false;

  slotBooked = false;

  sameContactNumber = false;

  memberDTO: any;

  currentDate = new Date();

  constructor(private router:Router, private membersService:MembersService, private hospitalsService:HospitalsService, private plansService:PlansService, public dialog:MatDialog) 
  {
   }

  ngOnInit(): void {

    this.plansService.searchAllPlans().subscribe(
      (response:any)=>
      {
        this.allPlansList = response;
        console.log(this.allPlansList);
      }
    )

    this.hospitalsService.searchAllHospitalInformation().subscribe(
      (response: any)=>
      {
        this.allHospitalMapList = response;
      }
    )

    this.membersService.getAllMembers().subscribe(
      (response:any)=>
      {
        this.allMembersList = response;
      }
    )
  }

  setPlanDetails(list:any)
  {
    this.planId = list.plan.id;

    this.planCost = 0;

    for(let test of list.testList)
    {
      this.planCost += test.price;
    }
  }

  setHospitalDetails(list:any)
  {
    this.hospitalId = list.hospital.id;
  }

  onSubmit()
  {
    this.sameContactNumber = false;

    for(let member of this.allMembersList)
    {
      if(this.contactNumber==member.contactNumber)
      {
        this.sameContactNumber = true;
        return;
      }
    }

    this.slotBooked = false;

    for(let member of this.allMembersList)
    {
      if(member.appointmentDateDay==this.appointmentDate.getDate() && member.appointmentDateMonth==(this.appointmentDate.getMonth()+1) && member.appointmentDateYear==this.appointmentDate.getFullYear() && member.appointmentDateHour==this.appointmentDateHour && member.hospitalId==this.hospitalId)
      {
        this.slotBooked = true;
        return;
      }
    }

    var id = this.id;
    var address = this.address;
    var name = this.name;
    var gender = this.gender;
    var dobDay = this.dob.getDate();
    var dobMonth = this.dob.getMonth()+1;
    var dobYear = this.dob.getFullYear();
    var contactNumber = this.contactNumber;
    var emailId = this.emailId;
    var planId = this.planId;
    var planCost = this.planCost;
    var appointmentDateDay = this.appointmentDate.getDate();
    var appointmentDateMonth = this.appointmentDate.getMonth()+1;
    var appointmentDateYear = this.appointmentDate.getFullYear();
    var appointmentDateHour = this.appointmentDateHour;
    var hospitalId = this.hospitalId;

    if(this.slotBooked == false)
    {
      this.membersService.createMember({id,address,name,gender,dobDay,dobMonth,dobYear,contactNumber,emailId,planId,planCost,appointmentDateDay,appointmentDateMonth,appointmentDateYear,appointmentDateHour,hospitalId}).subscribe(
        response=>
        {
          console.log(response);
        }
      );

      let dialogRef = this.dialog.open(MemberregistrationdialogComponent, {
        width: '500px',
        data: {}
      });
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HospitalsService } from 'src/app/services/hospitals.service';
import { MembersService } from 'src/app/services/members.service';
import { PlansService } from 'src/app/services/plans.service';
import { MatDialog } from '@angular/material/dialog';
import { MemberdetailsupdatedialogComponent } from '../memberdetailsupdatedialog/memberdetailsupdatedialog.component';

@Component({
  selector: 'app-memberdetailsupdate',
  templateUrl: './memberdetailsupdate.component.html',
  styleUrls: ['./memberdetailsupdate.component.css']
})
export class MemberdetailsupdateComponent implements OnInit {

  memberDetails = this.membersService.memberDetails;

  id = this.memberDetails.id;

  address = this.memberDetails.address;

  name = this.memberDetails.name;

  gender = this.memberDetails.gender;

  dob = new Date(this.memberDetails.dobYear, this.memberDetails.dobMonth-1, this.memberDetails.dobDay);
  dobDay = '';
  dobMonth = '';
  dobYear = '';

  contactNumber = this.memberDetails.contactNumber;

  emailId = this.memberDetails.emailId;

  allPlansList: any;
  planId = this.memberDetails.planId;
  planCost = 0;
  planName = '';

  appointmentDate = new Date(this.memberDetails.appointmentDateYear, this.memberDetails.appointmentDateMonth-1, this.memberDetails.appointmentDateDay);
  appointmentDateDay = '';
  appointmentDateMonth = '';
  appointmentDateYear = '';
  appointmentDateHour = this.memberDetails.appointmentDateHour.toString();

  allHospitalMapList: any;
  hospitalId = this.memberDetails.hospitalId;
  hospitalName = '';

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

        for(let planWrapper of this.allPlansList)
        {
          if(this.memberDetails.planId==planWrapper.plan.id)
          {
            this.planName = planWrapper.plan.planName;
            for(let test of planWrapper.testList)
            {
              this.planCost += test.price;
            }
          }
        }
      }
    );

    this.hospitalsService.searchAllHospitalInformation().subscribe(
      (response: any)=>
      {
        this.allHospitalMapList = response;
        console.log(this.allHospitalMapList);
      }
    );

    this.membersService.getAllMembers().subscribe(
      (response:any)=>
      {
        this.allMembersList = response;
      }
    )
  }

  setHospitalDetails(list:any)
  {
    this.hospitalId = list.hospital.id;
  }

  onSubmit()
  {
    this.sameContactNumber = false;

    this.slotBooked = false;

    console.log(this.memberDetails.appointmentDateDay);
    console.log(this.appointmentDate.getDate());
    console.log(this.memberDetails.appointmentDateMonth);
    console.log(this.appointmentDate.getMonth());
    console.log(this.memberDetails.appointmentDateYear);
    console.log(this.appointmentDate.getFullYear());

    if(this.memberDetails.appointmentDateDay==this.appointmentDate.getDate() && this.memberDetails.appointmentDateMonth==(this.appointmentDate.getMonth()+1) && this.memberDetails.appointmentDateYear==this.appointmentDate.getFullYear() && this.memberDetails.appointmentDateHour==this.appointmentDateHour && this.memberDetails.hospitalId==this.hospitalId)
    {
      this.slotBooked = false;
    }

    else 
    {
    for(let member of this.allMembersList)
    {
      if(member.appointmentDateDay==this.appointmentDate.getDate() && member.appointmentDateMonth==(this.appointmentDate.getMonth()+1) && member.appointmentDateYear==this.appointmentDate.getFullYear() && member.appointmentDateHour==this.appointmentDateHour && member.hospitalId==this.hospitalId)
      {
        this.slotBooked = true;
        return;
      }
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
      this.membersService.updateMember({id,address,name,gender,dobDay,dobMonth,dobYear,contactNumber,emailId,planId,planCost,appointmentDateDay,appointmentDateMonth,appointmentDateYear,appointmentDateHour,hospitalId}).subscribe(
        response=>
        {
          console.log(response);
        }
      );

      let dialogRef = this.dialog.open(MemberdetailsupdatedialogComponent, {
        width: '500px',
        data: {}
      });
    }
  }

}

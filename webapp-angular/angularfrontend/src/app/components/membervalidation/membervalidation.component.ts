import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MembersService } from 'src/app/services/members.service';

@Component({
  selector: 'app-membervalidation',
  templateUrl: './membervalidation.component.html',
  styleUrls: ['./membervalidation.component.css']
})
export class MembervalidationComponent implements OnInit {

  memberDTO = 
  {
    name: '',
    contactNumber: ''
  };

  invalidCredentials = false;

  constructor(private membersService:MembersService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    this.membersService.getMemberByNameContactNumber(this.memberDTO).subscribe(
      (response:any)=>
      {
        console.log(response);
        this.membersService.memberDetails = response;
        this.router.navigate(['memberdetails']);
      },
      error=>
      {
        console.log(error);
        this.invalidCredentials = true;
      }
    );
  }

}

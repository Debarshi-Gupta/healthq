import { Component, OnInit } from '@angular/core';
import { PlansService } from 'src/app/services/plans.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit {

  constructor(private plansService:PlansService, private router:Router) { }

  planTestWrapperObjectList: any;

  ngOnInit(): void {

    this.plansService.getAllPlan().subscribe(
      (response:any)=>
      {
        this.planTestWrapperObjectList = response;
        console.log(response);
      }
    )
  }

  getCreatePlan()
  {
    this.router.navigate(['createplan']);
  }

  getUpdatePlan(planTestWrapperObject:any)
  {
    this.plansService.updatePlanTestWrapperObject = planTestWrapperObject;
    this.router.navigate(['updateplan']);
  }

  deletePlan(planTestWrapperObject:any)
  {
    this.plansService.deletePlan(planTestWrapperObject.plan, planTestWrapperObject.testList).subscribe(
      response=>
      {
        console.log(response);
        location.reload();
      }
    )
  }


}

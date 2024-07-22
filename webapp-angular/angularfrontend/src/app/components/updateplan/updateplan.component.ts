import { Component, OnInit } from '@angular/core';
import { TestsService } from 'src/app/services/tests.service';
import { PlansService } from 'src/app/services/plans.service';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-updateplan',
  templateUrl: './updateplan.component.html',
  styleUrls: ['./updateplan.component.css']
})
export class UpdateplanComponent implements OnInit {

  constructor(private testsService:TestsService, private plansService:PlansService, private formBuilder:FormBuilder, private router:Router) { }

  plan= 
  {
    id: '',
    planName: '',
    description: ''
  }

  myForm: FormGroup;

  selectedItems: Array<any> = [];

  allTestList: Array<any> = [];

  dropdownSettings: any = {};

  limitSelection = false;

  ShowFilter = false;

  disabled = false;

  formEmpty= false;

  ngOnInit(): void {

    this.testsService.getAllTest().subscribe(
      (response:any)=>
      {
        this.allTestList = response;
        console.log(this.allTestList);
      }
    );

    this.plan.id = this.plansService.updatePlanTestWrapperObject.plan.id;
    this.plan.planName = this.plansService.updatePlanTestWrapperObject.plan.planName;
    this.plan.description = this.plansService.updatePlanTestWrapperObject.plan.description;

    this.selectedItems = this.plansService.updatePlanTestWrapperObject.testList;

    this.dropdownSettings =
    {
      singleSelection: false,
      idField: 'id',
      textField: 'testName',
      selectAllText: 'SELECT ALL',
      unSelectAllText: 'UNSELECT ALL',
      itemsShowLimit: 3,
      allowSearchFilter: this.ShowFilter
    };

    this.myForm = this.formBuilder.group({
      test: [this.selectedItems]
    });


  }

  onItemSelect(item: any)
  {
    console.log('onItemSelect', item);
  }

  onSelectAll(items: any)
  {
    console.log('onSelectAll', items)
  }

  toggleShowFilter()
  {
    this.ShowFilter = !this.ShowFilter;
    this.dropdownSettings = Object.assign({}, this.dropdownSettings, { allowSearchFilter: this.ShowFilter});
  }

  handleLimitSelection()
  {
    if(this.limitSelection)
    {
      this.dropdownSettings = Object.assign({}, this.dropdownSettings, { limitSelection: 2});
    }
    else 
    {
      this.dropdownSettings = Object.assign({}, this.dropdownSettings, { limitSelection: null});
    }
  }

  onSubmit()
  {
    if(this.plan.planName!='' && this.plan.description!='')
    {
      this.plansService.updatePlan(this.plan,this.selectedItems).subscribe(
        response=>
        {
          console.log(response);
          this.router.navigate(['plans']);
        },
        error=>
        {
          console.log(error);
        }
      )
    }

    else 
    {
      this.formEmpty = true;
    }
  }

}

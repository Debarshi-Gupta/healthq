import { Component, OnInit } from '@angular/core';
import { TestsService } from 'src/app/services/tests.service';
import { PlansService } from 'src/app/services/plans.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-createplan',
  templateUrl: './createplan.component.html',
  styleUrls: ['./createplan.component.css']
})
export class CreateplanComponent implements OnInit {

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
      this.plansService.createPlan(this.plan,this.selectedItems).subscribe(
        response=>
        {
          console.log(response);
          this.router.navigate(['plans']);
        }
      )
    }

    else 
    {
      this.formEmpty = true;
    }
  }

}

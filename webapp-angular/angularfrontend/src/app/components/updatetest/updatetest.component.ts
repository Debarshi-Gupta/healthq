import { Component, OnInit } from '@angular/core';
import { TestsService } from 'src/app/services/tests.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-updatetest',
  templateUrl: './updatetest.component.html',
  styleUrls: ['./updatetest.component.css']
})
export class UpdatetestComponent implements OnInit {

  constructor(private testsService:TestsService, private router:Router) { }

  updateTest = this.testsService.updateTestObject;

  testDetails=
  {
    id: '',
    testName: '',
    description: '',
    unit: '',
    range: '',
    price: ''
  };

  formEmpty = false;

  ngOnInit(): void {

    this.testDetails.id = this.updateTest.id;
    this.testDetails.testName = this.updateTest.testName;
    this.testDetails.description = this.updateTest.description;
    this.testDetails.unit = this.updateTest.unit;
    this.testDetails.range = this.updateTest.range;
    this.testDetails.price = this.updateTest.price;
  }

  onSubmit()
  {
    if(this.testDetails.testName!='' && this.testDetails.unit!='' && this.testDetails.range!='' && this.testDetails.price!='')
    {
      this.testsService.updateTest(this.testDetails).subscribe(
        response=>
        {
          console.log(response);
          this.router.navigate(['tests']);
        }
      )
    }
    else 
    {
      this.formEmpty = true;
    }
  }

}

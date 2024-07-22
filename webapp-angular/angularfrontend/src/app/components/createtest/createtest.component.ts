import { Component, OnInit } from '@angular/core';
import { TestsService } from 'src/app/services/tests.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-createtest',
  templateUrl: './createtest.component.html',
  styleUrls: ['./createtest.component.css']
})
export class CreatetestComponent implements OnInit {

  constructor(private testsService:TestsService, private router:Router) { }

  testDetails=
  {
    id: '',
    testName: '',
    description: '',
    unit: '',
    range: '',
    price: ''
  }

  formEmpty= false;

  ngOnInit(): void {
  }

  onSubmit()
  {
    if(this.testDetails.testName!='' && this.testDetails.unit!='' && this.testDetails.range!='' && this.testDetails.price!='')
    {
      this.testsService.createTest(this.testDetails).subscribe(
        response=>
        {
          console.log(response);
          this.router.navigate(['tests']);
        }
      )
    }
    else 
    {
      this.formEmpty= true;
    }
  }


}

import { Component, OnInit } from '@angular/core';
import { TestsService } from 'src/app/services/tests.service';
import { Router } from '@angular/router';
import { identifierName } from '@angular/compiler';

@Component({
  selector: 'app-tests',
  templateUrl: './tests.component.html',
  styleUrls: ['./tests.component.css']
})
export class TestsComponent implements OnInit {

  constructor(private testsService:TestsService, private router:Router) { }

  testList : any;

  ngOnInit(): void {

    this.testsService.getAllTest().subscribe(
      (response:any)=>{
        this.testList = response;
        console.log(this.testList);
      }
    );
  }

  getCreateTest()
  {
    this.router.navigate(['createtest']);
  }

  getUpdateTest(list:any)
  {
    this.testsService.updateTestObject=list;
    this.router.navigate(['updatetest']);
  }

  deleteTest(list:any)
  {
    this.testsService.deleteTest(list).subscribe(
      response=>
      {
        console.log(response);
        location.reload();
      }
    )
  }

}

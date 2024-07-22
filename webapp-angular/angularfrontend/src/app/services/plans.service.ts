import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PlansService {

  constructor(private httpClient:HttpClient) { }

  url='http://localhost:8083';

  getAllPlan()
  {
    return this.httpClient.get(`${this.url}/getAllPlan`);
  }

  createPlan(plan:any, testList:any)
  {
    return this.httpClient.post(`${this.url}/createPlan`, {plan, testList}, {responseType:'text'});
  }

  updatePlanTestWrapperObject:any;
  updatePlan(plan:any, testList:any)
  {
    return this.httpClient.post(`${this.url}/updatePlan`, {plan, testList}, {responseType:'text'});
  }

  deletePlan(plan:any, testList:any)
  {
    return this.httpClient.post(`${this.url}/deletePlan`, {plan, testList}, {responseType:'text'});
  }

  searchAllPlans()
  {
    return this.httpClient.get(`${this.url}/searchAllPlan`);
  }
}

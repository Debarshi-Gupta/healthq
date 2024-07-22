import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TestsService {

  constructor(private httpClient:HttpClient) { }

  url = 'http://localhost:8083';

  getAllTest()
  {
    return this.httpClient.get(`${this.url}/getAllTest`);
  }

  createTest(test:any)
  {
    return this.httpClient.post(`${this.url}/createTest`, test, {responseType:'text'});
  }

  updateTestObject:any;
  updateTest(test:any)
  {
    return this.httpClient.post(`${this.url}/updateTest`, test, {responseType:'text'});
  }

  deleteTest(test:any)
  {
    return this.httpClient.post(`${this.url}/deleteTest`, test, {responseType:'text'});
  }

}

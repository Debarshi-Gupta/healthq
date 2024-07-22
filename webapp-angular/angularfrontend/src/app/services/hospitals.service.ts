import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HospitalsService {

  constructor(private httpClient:HttpClient) { }

  url = 'http://localhost:8082';

  getAllHospitalInformation()
  {
    return this.httpClient.get(`${this.url}/getAllHospitalInformation`);
  }

  createHospital(hospital:any, hospitalAddress:any)
  {
    return this.httpClient.post(`${this.url}/createHospital`, {hospital, hospitalAddress}, {responseType: 'text'});
  }

  updateHospitalMap: any;
  updateHospital(hospital:any, hospitalAddress:any)
  {
    return this.httpClient.post(`${this.url}/updateHospital`, {hospital, hospitalAddress}, {responseType: 'text'});
  }

  deleteHospital(hospital:any, hospitalAddress:any)
  {
    return this.httpClient.post(`${this.url}/deleteHospital`, {hospital, hospitalAddress}, {responseType: 'text'});
  }

  searchAllHospitalInformation()
  {
    return this.httpClient.get(`${this.url}/searchAllHospitalInformation`);
  }
}

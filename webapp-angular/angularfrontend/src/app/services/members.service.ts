import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MembersService {

  constructor(private httpClient:HttpClient) { }

  url='http://localhost:8084';

  getAllMembers()
  {
    return this.httpClient.get(`${this.url}/getAllMembers`);
  }

  createMember(MemberDTO: any)
  {
    return this.httpClient.post(`${this.url}/createMember`, MemberDTO, {responseType:'text'});
  }

  updateMember(MemberDTO: any)
  {
    return this.httpClient.post(`${this.url}/updateMember`, MemberDTO, {responseType:'text'});
  }

  deleteMember(MemberDTO: any)
  {
    return this.httpClient.post(`${this.url}/deleteMember`, MemberDTO, {responseType:'text'});
  }

  getMemberByNameContactNumber(MemberDTO: any)
  {
    return this.httpClient.post(`${this.url}/getMemberByNameContactNumber`, MemberDTO);
  }

  memberDetails: any;
}

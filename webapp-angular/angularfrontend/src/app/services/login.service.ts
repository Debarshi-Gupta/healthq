import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  url = 'http://localhost:8081';
  generateToken(credentials:any)
  {
    return this.http.post(`${this.url}/login`, credentials, {responseType: 'text'});
  }

  logInUser(token:string)
  {
    localStorage.setItem("token",token);
  }

  isLoggedIn()
  {
    let token = localStorage.getItem('token');
    if(token==undefined || token==='' || token==null)
    {
      return false;
    }
    else 
    {
      return true;
    }
  }

  logout()
  {
    localStorage.removeItem('token');
    return true;
  }

  setUserId(userId:string):void 
  {
    localStorage.setItem("userid",userId);
  }

  getToken()
  {
    return localStorage.getItem('token');
  }
}

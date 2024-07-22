import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';
import { of } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials=
  {
    username:'',
    password:''
  };

  public loggedIn = true;

  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    if(this.credentials.username!='' && this.credentials.password!='' && this.credentials.username!=null && this.credentials.password!=null)
    {
      this.loginService.generateToken(this.credentials).subscribe(
        responseToken=>
        {
          console.log(responseToken);
          this.loginService.logInUser(responseToken);
          this.loggedIn = this.loginService.isLoggedIn();
          this.loginService.setUserId(this.credentials.username);
          window.location.href=("/dashboard");
        },
        error=>
        {
          console.log(error);
          console.log(this.loggedIn);
          this.loggedIn = false;
        }
      )
    }

    else 
    {
      console.log("Empty Form");
    }
  }

  getUsername()
  {
    return this.credentials.username;
  }

}

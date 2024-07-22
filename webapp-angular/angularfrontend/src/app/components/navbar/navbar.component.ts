import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public loggedIn = false;

  constructor(private loginService:LoginService, private router:Router) { }

  ngOnInit(): void {
    console.log(this.loggedIn);
    this.loggedIn = this.loginService.isLoggedIn();
    console.log(this.loggedIn);
  }

  logoutUser()
  {
    this.loginService.logout();
    console.log("LOGGED OUT");
    location.reload();
  }

}

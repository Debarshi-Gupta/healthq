import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  // images = [
  //   {title: 'First Slide', short: 'First Slide Short', src: "/assets/carousel1.jpg"},
  //   {title: 'Second Slide', short: 'Second Slide Short', src: "/assets/plan.jpg"},
  //   {title: 'Third Slide', short: 'Third Slide Short', src: "/assets/test.jpg"}
  // ]

  images = [
    
  ]

  constructor(private router:Router, config: NgbCarouselConfig) {
    config.interval = 5000;
    config.keyboard = false;
    config.pauseOnHover = false;
    config.animation = false
   }

  ngOnInit(): void {
  }

  getHome()
  {
    this.router.navigate(['home']);
  }

}

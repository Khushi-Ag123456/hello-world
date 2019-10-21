import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-side-bar',
  templateUrl: './nav-side-bar.component.html',
  styleUrls: ['./nav-side-bar.component.css']
})
export class NavSideBarComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit() {
  }

  goToHome(category) {
    this.router.navigate(['/all-items/', category]);
  }

}

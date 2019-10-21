import { Component, OnInit } from '@angular/core';
import { ShoppingService } from '../shopping.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  cartCount : number;
  constructor(private service : ShoppingService, private router : Router) { }

  ngOnInit() {
  }

  goToCart() {
    alert("navigate");
    this.router.navigate(['/cart']);
  }
  updateCartCount() {

  }

}

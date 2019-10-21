import { Component, OnInit } from '@angular/core';
import { ShoppingService } from '../shopping.service';
import { Item } from '../item';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  itemsArr : Item[] = [];
  constructor(private service : ShoppingService, private router : Router) { }

  ngOnInit() {
    this.itemsArr = this.service.getAllItems();
  }

  decrementItem(itemId) {
    this.service.decrementItem(itemId);
  }

  incrementItem(itemId) {
    this.service.incrementItem(itemId);
  }

  goToCheckOut() {
    this.router.navigate(['/checkOut']);
  }

}

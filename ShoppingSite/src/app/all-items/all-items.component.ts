import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { ShoppingService } from '../shopping.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-all-items',
  templateUrl: './all-items.component.html',
  styleUrls: ['./all-items.component.css']
})
export class AllItemsComponent implements OnInit {

  itemsArr : Item[];
  
  constructor(private service : ShoppingService, private router : Router, private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    // var category = this.activatedRoute.snapshot.paramMap.get("category");
    this.itemsArr = this.service.getAllItems();
    
    // if (category == "All") {
    //    return;
    //  }  
    // this.itemsArr = this.itemsArr.filter(item => item.category == category);
   
  }

  getItems(category) {
    this.itemsArr = this.service.getAllItems();
    if (category == "All") {
      return this.itemsArr;
    }  
    this.itemsArr = this.itemsArr.filter(item => item.category == category);
    return this.itemsArr;
  }
  AddToCart(itemId) {
    this.service.addToCart(itemId);
  }


}

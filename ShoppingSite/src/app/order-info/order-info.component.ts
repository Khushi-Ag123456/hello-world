import { Component, OnInit } from '@angular/core';
import { ShoppingService } from '../shopping.service';
import { Item } from '../item';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order-info',
  templateUrl: './order-info.component.html',
  styleUrls: ['./order-info.component.css']
})
export class OrderInfoComponent implements OnInit {

  constructor(private service : ShoppingService, private activatedRoute :ActivatedRoute ) { }

  itemsArr : Item[];
  ngOnInit() {
    var date = this.activatedRoute.snapshot.paramMap.get("OrderDate").toString();
    var orders = this.service.getAllOrder();
    for(var i = 0 ; i < orders.length; i++) {
      if(orders[i].OrderDate.toString() == date) {
        this.itemsArr =[];
        this.itemsArr = orders[i].OrderItems;
      
      }
    }
  }

}

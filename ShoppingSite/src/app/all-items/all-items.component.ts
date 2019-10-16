import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { ShoppingService } from '../shopping.service';

@Component({
  selector: 'app-all-items',
  templateUrl: './all-items.component.html',
  styleUrls: ['./all-items.component.css']
})
export class AllItemsComponent implements OnInit {

  itemsArr : string[];
  
  constructor(private service : ShoppingService) { }

  ngOnInit() {
    this.itemsArr = this.service.getAllItems();
    alert(this.itemsArr.length);
  }

}

import { Component, OnInit } from '@angular/core';
import { ShoppingService } from '../shopping.service';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(private service : ShoppingService) { }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { ShoppingService } from '../shopping.service';
import { Item } from '../item';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OrderDetails } from '../order-details';
import { ɵINTERNAL_BROWSER_PLATFORM_PROVIDERS } from '@angular/platform-browser';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  itemsArr : Item[] = [];
  OrderForm: FormGroup;
  submitted = false;
  orderModel : OrderDetails;

   constructor(private service : ShoppingService, private router :  Router, private formbuilder: FormBuilder) { }

  ngOnInit() {
    this.itemsArr = this.service.getAllItems();
    this.OrderForm = this.formbuilder.group({
      Name: ['', Validators.required],
      Address1: ['', Validators.required],
      Address2: [''],
      City : ['', Validators.required]
    });
  }

  placeOrder() {
    this.submitted = true;
    if(this.OrderForm.invalid) {
      return;
    }
    this.Add();
    this.router.navigate(['/confirmed']);
    //this.service.reset();
  }
 

  get fval() {
    return this.OrderForm.controls;
  }

  save(orderModel) {
    this.service.placeOrder(orderModel);
  }


  Add() {
    if(this.OrderForm.invalid) {
      return;
    }
    var orderModel = new OrderDetails(this.OrderForm.value.Name, this.OrderForm.value.Address1, this.OrderForm.value.Address2
      , this.OrderForm.value.City, Date.now(), this.itemsArr); 
      this.save(orderModel);  
  }

}

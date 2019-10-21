import { Injectable } from '@angular/core';
import { Item } from './item';
import { Observable } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { OrderDetails } from './order-details';

@Injectable({
  providedIn: 'root'
})
export class ShoppingService {

  Orders :  OrderDetails[] = [];
  order : OrderDetails
  cartCount : number = 0;
  itemsArr : Item[] = [];
  cart :  any[];

  constructor(private httpClient : HttpClient) {
   this.httpClient.get<Item[]>('http://localhost:4200/assets/app.json').subscribe(data => {
     data.forEach(item => {
       this.itemsArr.push(item);
     })
   })
}

placeOrder(orderModel: OrderDetails) {
  localStorage.setItem(orderModel.OrderDate.toString(), JSON.stringify(orderModel));
}

getAllOrder() {
  this.Orders = [];
  for (let key in localStorage) {
    if (localStorage.getItem(String(key)) != null) {
        this.Orders.push(this.stringToOrders(localStorage.getItem(String(key))));
    }
}
return this.Orders;
}



stringToOrders(str) {
      this.order = JSON.parse(str);
      return this.order;
}
  
getAllItems(){
    return this.itemsArr;
  }

  
  addToCart(itemId) {
    
    // console.log(this.httpClient.post('http://localhost:4200/assets/app.json', this.postData, {
    //   headers : new HttpHeaders({
    //     'Content-Type' : 'application/json'
    //   })
    // }));
    // this.httpClient.post("http://localhost:4200/assets/app.json", this.postData).subscribe(function() {
    //   console.log("done");
    // })
    this.cartCount++;
  //   for (let key in localStorage) {
  //     if (localStorage.getItem(String(key)) != null && key == itemId.toString()) {
  //         var value = localStorage.getItem(key);
  //         var quantity = parseInt(quantity) + 1;
  //         localStorage.setItem(key, quantity.toString);
  //     } else {
  //         localStorage.setItem(itemId.toString(), "1");
  //     }
  // }
  for(var i = 0; i < this.itemsArr.length; i++) {
    if(this.itemsArr[i].id == itemId) {
        this.itemsArr[i].quantity++;
    }
  }
  return this.cartCount;
  }

  incrementItem(itemId) {
    this.cartCount++;
    for(var i = 0; i < this.itemsArr.length; i++) {
      if(this.itemsArr[i].id == itemId) {
          this.itemsArr[i].quantity++;
      }
    }
    return this.cartCount
  }

  decrementItem(itemId) {
    for(var i = 0; i < this.itemsArr.length; i++) {
      if(this.itemsArr[i].id == itemId) {
          if(this.itemsArr[i].quantity > 0) {
            this.itemsArr[i].quantity--;
            this.cartCount--;
          }
      }
    }
    return this.cartCount;
  }

  reset() {
    for(var i = 0; i < this.itemsArr.length; i++) {
      this.itemsArr[i].quantity = 0;
      this.cartCount = 0;
  }
}

getTotal() {
  var total = 0;
  for(var i = 0; i < this.itemsArr.length ; i++) {
    total = +total + +(this.itemsArr[i].quantity * Number(this.itemsArr[i].price));
  }
  return total;
}

}


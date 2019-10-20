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
   this.httpClient.get<Item[]>('./assets/app.json').subscribe(data => {
     data.forEach(item => {
       this.itemsArr.push(item);
     })
   })
}

placeOrder(orderModel: OrderDetails) {
  alert(JSON.stringify(orderModel));
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



stringToOrders(str: string) {
  // var tempStr = str.split("]");
  // alert(tempStr[0]);
  // alert(tempStr[1]);
  var tempStr = str.split(",");
      this.order = new OrderDetails(String(tempStr[0]), String(tempStr[1]),
          String(tempStr[2]), String(tempStr[3]), tempStr[4], [tempStr[5], tempStr[6], tempStr[7], tempStr[8], tempStr[9]]);

  return this.order;
}
  
// OrdersToString(orders: OrderDetails) {
//   alert(JSON.stringify(orders));
//   var tTs = orders.Name + "," + orders.Address1 + "," + orders.Address2 + "," + orders.City + "," + orders.OrderDate + "," + orders.OrderItems;
//   alert(tTs);
//   return tTs;
// }
  

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
  }
}

}


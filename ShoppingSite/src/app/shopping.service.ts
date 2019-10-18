import { Injectable } from '@angular/core';
import { Item } from './item';
import { Observable } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShoppingService {

  constructor(private httpClient : HttpClient) {
   this.httpClient.get<Item[]>('./assets/app.json').subscribe(data => {
     data.forEach(item => {
       this.itemsArr.push(item);
     })
   })
}

  itemsArr : Item[] = [];
  cart :  any[];

  getAllItems(){
    return this.itemsArr;
  }

  postData = {
    "id": 6,
    "title": "Freshly Baked Bread",
    "price": 3.5,
    "imageUrl": "img/bread.jpg",
    "category": "Bread"
  };
  addToCart(itemId) {
    
    // console.log(this.httpClient.post('http://localhost:4200/assets/app.json', this.postData, {
    //   headers : new HttpHeaders({
    //     'Content-Type' : 'application/json'
    //   })
    // }));
    // this.httpClient.post("http://localhost:4200/assets/app.json", this.postData).subscribe(function() {
    //   console.log("done");
    // })
    localStorage.setItem(itemId.toString(), "0");
  }
}



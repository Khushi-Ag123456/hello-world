import { Injectable } from '@angular/core';
import { Item } from './item';
import { Observable } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShoppingService {

  constructor(private httpClient : HttpClient) {
    this.httpClient.get('./assets/app.json').subscribe(
      data => {
        this.itemsArr.push(data.toString());
        console.log(this.itemsArr[1]);
      },
      (err: HttpErrorResponse) => {
        console.log (err.message);
      }
    );
}

  private JsonUrl =  '__appData/app.json';

  itemsArr : string[] = [];

  getAllItems(){
    return this.itemsArr;
  }
}

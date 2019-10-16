import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { NavSideBarComponent } from './nav-side-bar/nav-side-bar.component';
import { AllItemsComponent } from './all-items/all-items.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    NavSideBarComponent,
    AllItemsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

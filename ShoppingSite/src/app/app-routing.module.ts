import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllItemsComponent } from './all-items/all-items.component';
import { NavSideBarComponent } from './nav-side-bar/nav-side-bar.component';


const routes: Routes = [ { path : 'all-items/:category', component : AllItemsComponent },
{path : 'home', component : NavSideBarComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

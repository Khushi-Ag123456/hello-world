import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { TasksComponent } from './tasks/tasks.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule } from '@angular/forms';
import { ModalBoxComponent } from './modal-box/modal-box.component';



@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    HeaderComponent,
    ModalBoxComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {
         path: 'tasks-cmp',
         component: TasksComponent
      }
   ]),
   FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

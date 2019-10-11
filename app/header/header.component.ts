import { Component, OnInit  } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from '../task';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  taskArr: Task[] = [];
  constructor(private router : Router, ) { }

  ngOnInit() {
  }

  priorities = ["High", "Medium", "Low"];
  taskStatus = ["New", "In Progress", "Completed"];
  
  onClickSubmit(data) {
     this.taskArr.push(data);
     alert(this.taskArr.length);
 }
}

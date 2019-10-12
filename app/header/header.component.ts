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
  taskid : number = 1;
  constructor(private router : Router, ) { }

  ngOnInit() {
  }

  priorities = ["High", "Medium", "Low"];
  taskStatus = ["New", "In Progress", "Completed"];
  
  onClickSubmit(data) {
    data.taskId = this.taskid++;
     this.taskArr.push(data);
 }

 deleteTask(taskId) {
   this.taskArr = this.taskArr.filter(task => task.taskId !== taskId);
 }
}

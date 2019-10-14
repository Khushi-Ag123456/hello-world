import { Component, OnInit } from '@angular/core';
import { Task } from '../task';


@Component({
  selector: 'app-modal-box',
  templateUrl: './modal-box.component.html',
  styleUrls: ['./modal-box.component.css']
})
export class ModalBoxComponent implements OnInit {


  taskArr: Task[] = [];
  taskid : number = 1;
  constructor() { }
  
  ngOnInit() {
  }

  priorities = ["High", "Medium", "Low"];
  taskStatus = ["New", "In Progress", "Completed"];

  onClickSubmit(data) {
    data.taskId = this.taskid++;
     this.taskArr.push(data);
 }

 editTask(taskId, data) {
  if (taskId) {
    alert("inside");
    for(let task of this.taskArr) {
      if(task.taskId == taskId) {
        data.taskId = taskId;
        task = data;
        break;
      }
    }
  } else {
    alert("another one");
      this.onClickSubmit(data);
  }
}

}

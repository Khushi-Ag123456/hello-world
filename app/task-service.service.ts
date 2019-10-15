import { Injectable } from '@angular/core';
import { Task } from './task';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {

  taskArr : Task[] = [];

  constructor() { }

  addTask(task : Task, taskType : String) : void {
    if (taskType == 'Add') {
      task.taskId++;
      alert(task.taskId);
      this.taskArr.push(task);
    } else {
      for(let task1 of this.taskArr) {
        if(task1.taskId == task.taskId) {
          task = task1;
        }
      }
    }
  }

  getTask()  : Task[] {
    return this.taskArr;
  }

  deleteTask(taskId) : Task[] {
    alert(taskId)
    this.taskArr = this.taskArr.filter(task => task.taskId !== taskId);
    return this.taskArr;
  }
}

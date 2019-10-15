import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { TaskServiceService } from '../task-service.service';
import { Task } from '../task';


@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {


  taskArr : Task[] = [];
  id : number = 0;


  // taskForm = this.fb.group({
  //   taskId : [],
  //   taskTitle : [''],
  //   taskDesc : [''],
  //   status : ['New'],
  //   creationDate : [''],
  //   completionDate : [''],
  //   priority : ['']
  // });


  // task : Task = {
  //   taskId : this.id++,
  //   taskTitle : this.taskForm.get("taskTitle").value,
  //   taskDesc : this.taskForm.get("taskDesc").value,
  //   status : this.taskForm.get("status").value,
  //   creationDate : this.taskForm.get("creationDate").value,
  //   completionDate : this.taskForm.get("completionDate").value,
  //   priority : this.taskForm.get("priority").value
  // };

 
  constructor(private fb: FormBuilder, private taskServiceService : TaskServiceService) { }

  priorities = ["High", "Medium", "Low"];
  taskStatus  = ["New", "In Progress", "Completed"];
 
  ngOnInit() {
    this.taskArr = this.getTasks();
  }

  onSubmit(task) {
    this.taskServiceService.addTask(task, this.taskType);
    task.reset();
  }


  getTasks() : Task[] {
    return this.taskServiceService.getTask();
  }

  deleteTask(taskId) : void {
   
    this.taskArr = this.taskServiceService.deleteTask(taskId);
  }

  editTask(taskId) {
  }
}

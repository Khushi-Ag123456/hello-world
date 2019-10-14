import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from '../task';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  @Input() taskArr : Task[];
  @Output() editTaskEmitterCallBack = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

  deleteTask(taskId) {
    this.taskArr = this.taskArr.filter(task => task.taskId !== taskId);
  }
 
  editTask(task) {
    
    this.editTaskEmitterCallBack.emit(task);
  }

}

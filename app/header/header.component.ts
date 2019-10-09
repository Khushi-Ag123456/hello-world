import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router : Router, ) { }

  ngOnInit() {
  }

  priorities = ["High", "Medium", "Low"];
  taskStatus = ["New", "In Progress", "Completed"];
  
process() {
 alert("Hiii");
}

createNewTask() {
  this.router.navigate(['/tasks-cmp'])
}
}

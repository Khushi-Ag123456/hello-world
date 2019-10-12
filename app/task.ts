export class Task {
    taskId : number = 0;
    taskTitle : string = '';
    taskDesc : string = '';
    status : string = '';
    creationDate : Date;
    completionDate : Date;
    priority : string = '';
    
    constructor(values: Object = {}) {
        this.taskId = this.taskId + 1;
        Object.assign(this, values);
      }
}

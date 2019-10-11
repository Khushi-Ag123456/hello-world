export class Task {

    taskTitle : string = '';
    taskDesc : string = '';
    status : string = '';
    creationDate : Date;
    completionDate : Date;
    priority : string = '';
    
    constructor(values: Object = {}) {
        Object.assign(this, values);
      }
}

import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs/internal/BehaviorSubject";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private employee = new BehaviorSubject(null);
  currentEmployee = this.employee.asObservable();
  constructor() { }

  changeEmployee(employee:any){
    this.employee.next(employee);
  }
}

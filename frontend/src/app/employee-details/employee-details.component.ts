import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {EmployeeService} from "../shared/employee.service";

@Component({
    selector: 'app-employee-details',
    templateUrl: './employee-details.component.html',
    styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
    Employee:any = [];

    constructor(private employee: EmployeeService,
                private router: Router) { }

    ngOnInit() {
      this.employee.currentEmployee.subscribe(employee => this.Employee = employee);
      console.log(this.Employee);
    }

    goBack(){
      this.router.navigate(['']);
    }
}

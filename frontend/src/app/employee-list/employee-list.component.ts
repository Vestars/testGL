import { Component, OnInit } from '@angular/core';
import {RestApiService} from "../shared/rest-api.service";
import {Router} from "@angular/router";
import {EmployeeService} from "../shared/employee.service";

@Component({
    selector: 'app-employee-list',
    templateUrl: './employee-list.component.html',
    styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

    Pageable:any = {};
    Pages:any = [];

    constructor(public restApi: RestApiService,
                public employee: EmployeeService,
                public router: Router) { }

    ngOnInit() {
        this.loadEmployees(1);
    }

    loadEmployees(page) {
        if(this.Pageable && this.Pageable.pageNumber === page){
            return;
        }

        return this.restApi.getEmployees(page).subscribe((data) => {
            this.Pageable = data;
            this.Pages.length = data.totalPages;
            this.Pages = this.Pages.fill().map((x,i)=>i+1);
        })
    }

    setEmployeeAndNavigate(employee){
        this.employee.changeEmployee(employee);
        this.router.navigate(['/details']);
    }
}

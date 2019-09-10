import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {EmployeeDetailsComponent} from "./employee-details/employee-details.component";

const routes: Routes = [
    { path: '', pathMatch: 'full', component: EmployeeListComponent },
    { path: 'details', component: EmployeeDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

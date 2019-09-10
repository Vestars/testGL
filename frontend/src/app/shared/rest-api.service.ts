import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs/internal/Observable";
import {catchError} from "rxjs/operators";
import {throwError} from "rxjs/internal/observable/throwError";

const API_URL = environment.apiUrl;

@Injectable({
    providedIn: 'root'
})
export class RestApiService {

    constructor(private http: HttpClient) { }

    getEmployees(page): Observable<any> {
        return this.http.get(API_URL + '/employees?page=' + page)
            .pipe(
                catchError(error => {
                    let errorMessage = '';
                    if(error.error instanceof ErrorEvent) {
                        errorMessage = error.error.message;
                    } else {
                        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
                    }
                    return throwError(errorMessage);
                })
            );
    }
}

import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable()
export class CommitteeService {


	constructor(private http: Http) { }

    getOne(id: string): Observable<any> {
        return this.http.get(environment.apiUrl + '/committee/' + id)
        	      .map((response: Response) => response.json());
	}

    getFilingsByYear(id: string, year: number){
        return this.http.get(environment.apiUrl + '/committee/' + id + '/filings/' + year)
                  .map((response: Response) => response.json());
    }
}

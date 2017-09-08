import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs';

@Injectable()
export class CommitteeService {


	constructor(private http: Http) { }

    getOne(id: string): Observable<any> {
        var apiUrl = "http://dev-backend-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com"
		return this.http.get(apiUrl + '/committee/' + id)
	      .map((response: Response) => response.json());
	}

    getFilingsByYear(id: string, year: number){
    	var apiUrl = "http://dev-backend-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com"
    	return this.http.get(apiUrl + '/committee/' + id + '/filings/' + year)
    	      .map((response: Response) => response.json());
    }
}

import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';

@Injectable()
export class FilingService {

  constructor(private http: Http) { }

    getOne(file_id: string): Observable<any> {
        return this.http.get(environment.apiUrl + '/filing/' + file_id)
		.map((response: Response) => response.json());
	}

    getByYear(committee_id: string, year: number){
        return this.http.get(environment.apiUrl + '/committee/' + committee_id + '/filings/' + year)
		.map((response: Response) => response.json());
    }
}

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

    getByYear(committee_id: string, year: number, type: string){
    	var url = environment.apiUrl + '/committee/' + committee_id + '/filings/' + year + (type ? '/' + type : '');
        return this.http.get(url)
         	.map((response: Response) => response.json());
    }
}

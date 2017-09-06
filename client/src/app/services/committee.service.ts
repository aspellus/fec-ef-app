import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs';

@Injectable()
export class CommitteeService {

	constructor(private http: Http) { }

	  getAll(): Observable<any> {
	    return this.http.get('https://api.open.fec.gov/v1/committees/?api_key=tXL6l6lELFouuaG2ZiLrFedd2MVx8yxPn5Jyas3y')
	      .map((response: Response) => response.json());
	  }

}

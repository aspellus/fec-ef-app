import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs';

@Injectable()
export class CommitteeService {

	constructor(private http: Http) { }

	getOne(id: string): Observable<any> {
		return this.http.get('http://localhost:8080/committee/' + id)
	      .map((response: Response) => response.json());
	}
}

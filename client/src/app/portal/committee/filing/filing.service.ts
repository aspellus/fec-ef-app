import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
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
    
    getReceipts(report_id: number) {
    	var url = environment.apiUrl + '/report/' + report_id + '/receipts/';
        return this.http.get(url)
         	.map((response: Response) => response.json());
    }
    
    saveReceipt(receipt: any){
    	var url = environment.apiUrl + '/schedules/' + receipt.repid + '/schedule_a/' + receipt.tran_id;
	let headers = new Headers({ 'Content-Type': 'application/json' });
	let options = new RequestOptions({ headers: headers });
    	
    	return this.http[Boolean(receipt.tran_id) ? 'put' : 'post'](url, receipt, options).map((response: Response) => response.json());
    }
    
    deleteReceipt(receipt: any){
    	var url = environment.apiUrl + '/schedules/' + receipt.repid + '/schedule_a/' + receipt.tran_id;
    	return this.http.delete(url).map((response: Response) => response.json());
    }
}

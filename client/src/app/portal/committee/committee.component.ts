import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/switchMap';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {NgbPanelChangeEvent} from '@ng-bootstrap/ng-bootstrap';

import { CommitteeService } from "./committee.service";
import { FilingService } from "./filing/filing.service";

@Component({
  selector: 'app-committee',
  templateUrl: './committee.component.html',
  styleUrls: ['./committee.component.scss']
})
export class CommitteeComponent implements OnInit {

	doShow: string = 'filings';
	isLoading: boolean = false;
	committee: any = {};
	filingData: any = [];
	filingYear: number;
	years: Array<number> = [];
	formType: string;
	formTypes: Array<String> = [];

	constructor(private route: ActivatedRoute, private router: Router, private committeeService: CommitteeService, private filingService: FilingService) { }

	ngOnInit() {
		var id = this.route.snapshot.paramMap.get('id');
		this.committeeService.getOne(id).subscribe(
				data => {
					this.committee = data.results[0];
					this.getFilingData();
		    },
		    error => console.log(error)
		);
		
		for(let i = 2017; i > 2010; i--){
			this.years.push(i);
		}
		
		this.filingYear = this.years[0];
	}
	
	
	getData() {
		if(this.formType){
			return this.filingData.filter(filing => {
				let type = filing.form_type;

				return type && this.formType === type;
			});
		}
		
		return this.filingData;
	}
	private getFilingData(){
		this.formTypes = [];
		this.formType = '';
		this.isLoading = true;

		this.filingService.getByYear(this.committee.committee_id, this.filingYear, this.formType).subscribe(
				data => {
					this.filingData = data.results;
					this.filingData.forEach(filing => {
						let type = filing.form_type;
						
						if(type && !this.formTypes.includes(type)){
							this.formTypes.push(type);
						}
					});
					this.isLoading = false;
		    },
		    error => console.log(error)
		);
	}
}

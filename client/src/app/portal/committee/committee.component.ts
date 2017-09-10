import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/switchMap';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {NgbPanelChangeEvent} from '@ng-bootstrap/ng-bootstrap';

import { CommitteeService } from "./committee.service";
import { FilingService } from "./filing/filing.service";

class FilingFilter {
	constructor(){};
	filingYear: number;
	formType: string;
	
	getQueryParams(){
		if (this.formType) {
			return { 
				filing_year: this.filingYear, 
				form_type: this.formType
			};
		}
		
		return { 
			filing_year: this.filingYear
		};
	}
}

const FORM_TYPES_HIDDEN: string[] = [
                        'RFAI',
                        'F1'
                      ];

@Component({
  selector: 'app-committee',
  templateUrl: './committee.component.html',
  styleUrls: ['./committee.component.scss']
})
export class CommitteeComponent implements OnInit {

	doShow: string = 'filings';
	isLoading: boolean = false;
	filters: FilingFilter = new FilingFilter();
	committee: any = {};
	filingData: any = [];
	years: Array<number> = [];
	formTypes: Array<String> = [];

	constructor(private route: ActivatedRoute, private router: Router, private committeeService: CommitteeService, private filingService: FilingService) { }

	ngOnInit() {
		var id = this.route.snapshot.paramMap.get('id');
		this.committeeService.getOne(id).subscribe(
				data => {
					this.committee = data.results[0];
					this.committeeService.committee = this.committee;
					this.getFilingData();
		    },
		    error => console.log(error)
		);
		
		for(let i = 2017; i > 2010; i--){
			this.years.push(i);
		}
		
		this.route.queryParams.subscribe(params => {
			this.filters.filingYear = params['filing_year'] ? params['filing_year'] : this.years[0];
			this.filters.formType = params['form_type'] ? params['form_type'] : null;
		 });
	}
	
	private getQueryParams(){
		if (this.filters.formType) {
			return { 
				filing_year: this.filters.filingYear, 
				formType: this.filters.formType
			};
		}
		
		return { 
			filing_year: this.filters.filingYear
		};
	}
	
	updateUrl() {
		console.log('updating url');
		console.log(this.filters.getQueryParams());
		this.router.navigate([], {
	        queryParams: this.filters.getQueryParams(),
	        queryParamsHandling: 'merge',
	        relativeTo: this.route
	    });
	}
	
	getData() {
		if(this.filters.formType){
			return this.filingData.filter(filing => {
				let type = filing.form_type;

				return type && this.filters.formType === type;
			});
		}
		
		return this.filingData;
	}
	private getFilingData(){
		
		this.updateUrl();
		
		this.formTypes = [];
		this.filters.formType = '';
		this.isLoading = true;

		this.filingService.getByYear(this.committee.committee_id, this.filters.filingYear, this.filters.formType).subscribe(
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

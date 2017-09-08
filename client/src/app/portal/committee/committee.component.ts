import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/switchMap';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {NgbPanelChangeEvent} from '@ng-bootstrap/ng-bootstrap';

import { CommitteeService } from "./committee.service";

@Component({
  selector: 'app-committee',
  templateUrl: './committee.component.html',
  styleUrls: ['./committee.component.scss']
})
export class CommitteeComponent implements OnInit {

	committee: any = {};
	filingData: any = [];
	filingYear: number;
	years: Array<number> = [];

	doShow = 'committee-info';

	constructor(private route: ActivatedRoute, private router: Router, private committeeService: CommitteeService) { }

	ngOnInit() {
		console.log('committee init');
		
		var id = this.route.snapshot.paramMap.get('id');
		this.committeeService.getOne(id).subscribe(
				data => {
					this.committee = data.results[0];
		    },
		    error => console.log(error)
		);
		
		for(let i = 2017; i > 2010; i--){
			this.years.push(i);
		}
		
		this.filingYear = this.years[0];
	}
	
	public beforeChange($event: NgbPanelChangeEvent){
		if($event.panelId === 'committee-info-panel') {
		      $event.preventDefault();
		      this.doShow = 'committee-info';
	    }
		if($event.panelId === 'filings-panel') {
		      this.doShow = 'filings';
		      this.getFilingData();
	    }
	};
	
	selectYear(year: number){
		this.filingYear = year;
		this.getFilingData();
	}
	
	private getFilingData(){
		this.committeeService.getFilingsByYear(this.committee.committee_id, this.filingYear).subscribe(
				data => {
					this.filingData = data.results;
					//this.committeeService.committee = this.committee;
		    },
		    error => console.log(error)
		);
	}
}

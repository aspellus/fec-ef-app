import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-filings',
  templateUrl: './filings.component.html',
  styleUrls: ['./filings.component.scss']
})
export class FilingsComponent implements OnInit {

	@Input() filingData: any;
	@Input() filters: any;
	
  constructor(private router: Router) { }

  ngOnInit() {
  }
  
  viewFiling(fec_file_id){
  	this.router.navigate(['/filing/' + fec_file_id], {queryParams: {'filing_year': this.filters.filingYear}});
  }

  
  
  	isButtonHidden(filing: any) {
		return ['RFAI','F1'].includes(filing.formType) || !filing.fec_file_id;
	}
}

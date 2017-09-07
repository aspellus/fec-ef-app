import { Component, OnInit, Input } from '@angular/core';

import { Committee } from '../../../models/committee';

@Component({
  selector: 'app-filing-report',
  templateUrl: './filing-report.component.html',
  styleUrls: ['./filing-report.component.css']
})
export class FilingReportComponent implements OnInit {

	records = [];
	
  constructor() { }

  ngOnInit() {
	  for(var i = 1; i < 10; i++){
		  var rec = {
				  filingId: 'ID' + i,
				  filerName: 'Name ' + i,
				  filingType: 'Type',
				  version: '2.3.' + i,
				  receiptDate: new Date(),
				  status: 'Active'
		  };
		  this.records.push(rec);
	  }
  }

  @Input() committee: Committee;
  
}

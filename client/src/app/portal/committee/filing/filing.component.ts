import { Component, OnInit, Input } from '@angular/core';
import { Router, RouterLink, ActivatedRoute } from '@angular/router';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { FilingService } from "./filing.service";

class TranForm {
	constructor (repid: number, comid: string) {
		this.repid = repid;
		this.comid = comid;
	}
	
	repid: number;
	line_num: string;
	comid: string;
	tran_id: string;
	name: string;
	fname: string;
	mname: string;
	date_con: string;
	amount: number
	ytd: number
	transdesc: string;
	indemp: string;
	indocc: string;
	memo_code: string;
	$isSaving: boolean = false;
	$isDeleting: boolean = false;
}

@Component({
  selector: 'app-filing',
  templateUrl: './filing.component.html',
  styleUrls: ['./filing.component.scss']
})
export class FilingComponent implements OnInit {

  //filing = {"fec_url":"http://docquery.fec.gov/dcdev/posted/1178702.fec","opposition_personal_funds":null,"amendment_chain":[1178702],"total_communication_cost":null,"pdf_url":"http://docquery.fec.gov/pdf/692/201708119070320692/201708119070320692.pdf","senate_personal_funds":null,"form_type":"F3","office":null,"pages":4,"is_amended":false,"primary_general_indicator":"P","candidate_name":null,"state":null,"most_recent":true,"sub_id":"4081120171446512792","amendment_indicator":"N","cash_on_hand_beginning_period":0,"beginning_image_number":"201708119070320692","fec_file_id":"FEC-1178702","report_type":"Q2","update_date":"2017-08-11T21:12:34","debts_owed_to_committee":0,"ending_image_number":"201708119070320695","html_url":"http://docquery.fec.gov/cgi-bin/forms/C00577759/1178702/","report_year":2017,"election_year":null,"party":null,"committee_id":"C00577759","coverage_start_date":"2017-04-01T00:00:00","csv_url":"http://docquery.fec.gov/csv/702/1178702.csv","request_type":null,"previous_file_number":1178702,"house_personal_funds":null,"document_description":"JULY QUARTERLY 2017","document_type_full":null,"treasurer_name":null,"cycle":2018,"total_independent_expenditures":null,"total_disbursements":0,"candidate_id":null,"file_number":1178702,"committee_name":"UBERPAC","net_donations":null,"means_filed":"e-file","amendment_version":0,"document_type":null,"total_individual_contributions":null,"report_type_full":"JULY QUARTERLY","most_recent_file_number":1178702,"cash_on_hand_end_period":0,"total_receipts":0,"coverage_end_date":"2017-06-30T00:00:00","receipt_date":"2017-08-11T00:00:00","debts_owed_by_committee":0};
  filing: any = {};
  report_id: number;
  filing_year: number;
  form_type: string;
  receipts: Array<any> = [];
  lineNums: Array<any>;
  committee_id: string;
  committee: any;
  newTranForm: TranForm;
  glossaryTitle: string;
  glossaryBody: Array<string>;
  
  constructor(private router: Router, private route: ActivatedRoute, private filingService: FilingService, private modalService: NgbModal) {}

  ngOnInit() {
	  
	  this.lineNums = [{id: '11A', desc: 'Individual Contribution'},
	                    {id: '11B', desc: 'Political Party Contribution'},
	                    {id: '11C', desc: 'Political Committee (Other) Contribution'},
	                    {id: '12', desc: 'Transfer from Affiliated/Other Party Contribution'},
	                    {id: '15', desc: 'Offset to Operating Expenditure'},
	                    {id: '16', desc: 'Refund of Contribution Made'},
	                    {id: '17', desc: 'Federal Receipt (Other)'},
	                    {id: '18A', desc: 'Transfers from Non-Federal Account'},
	                    {id: '18B', desc: 'Transfer from Levin Funds'}];
	  
	  this.route.params.subscribe(params => {
		 this.report_id = params['file_id']; 
		 this.committee_id = params['committee_id'];
		 this.initTranForm();
	  });
	  this.route.queryParams.subscribe(params => {
		  this.filing_year = params['filing_year'];
		  this.form_type = params['form_type'] ? params['form_type'] : null;
	  });
	  

	  this.filingService.getByYear(this.committee_id, this.filing_year, this.form_type).subscribe(data => {
		  this.filing = data.results.find(filing => {
			  return filing.file_number == this.report_id;
		  });
	  });
	  
	  this.filingService.getReceipts(this.report_id).subscribe(data => {
		this.receipts = data.list;
		this.sortReceipts();
		this.receipts.forEach(receipt => {
			receipt.date_con = receipt.date_con.split('T')[0];
			receipt.$isSaving = false;
			receipt.$isDeleting = false;
		});
	  });
  }
  
  initTranForm() {
	  this.newTranForm = new TranForm(this.report_id, this.committee_id);
  }
  
  sortReceipts(){
	this.receipts.sort(function(receipt_a, receipt_b){
		var line_num_a = receipt_a.line_num.toUpperCase(),
			line_num_b = receipt_a.line_num.toUpperCase(),
			date_a = new Date(receipt_a.date_con),
			date_b = new Date(receipt_b.date_con),
			name_a = (receipt_a.name + receipt_a.fname).toUpperCase(),
			name_b = (receipt_b.name + receipt_b.fname).toUpperCase();

		if (line_num_a < line_num_b) { return -1; }
		if (line_num_a > line_num_b) { return 1; }
		if (date_a < date_b) { return -1; }
		if (date_a > date_b) { return 1; }
		if (name_a < name_b) { return -1; }
		if (name_a > name_b) { return 1; }
		if (receipt_a.amount < receipt_b.amount) { return -1; }
		if (receipt_a.amount > receipt_b.amount) { return 1; }

		return 0;
	  });
  }
  
  	saveReceipt(receipt){
  		let isNew = !Boolean(receipt.tran_id);
  		receipt.$isSaving = true;
  		receipt.date_con = receipt.date_con + 'T05:00:00';
  		receipt.comid = this.committee_id;
	
		this.filingService.saveReceipt(receipt).subscribe(data => {
			receipt.$isSaving = false;
			if (!isNew) {
				receipt = data;
			} else {
				data.date_con = data.date_con.split('T')[0];
				this.receipts.push(data);
				this.initTranForm();
			}
	  	});
  }
  deleteReceipt(receipt){
	receipt.$isDeleting = true;
  	this.filingService.deleteReceipt(receipt).subscribe(resp => {
  		var index = this.receipts.findIndex(r => {
			return r.tran_id == receipt.tran_id;
		});
		this.receipts.splice(index, 1);
  	});
  }

  openGlossary(modal, title, body) {
	this.glossaryTitle = title;
	this.glossaryBody = body;
	this.modalService.open(modal, {size: 'lg'});
  }
}

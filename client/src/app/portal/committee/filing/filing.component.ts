import { Component, OnInit, Input } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-filing',
  templateUrl: './filing.component.html',
  styleUrls: ['./filing.component.scss']
})
export class FilingComponent implements OnInit {

  filing = {"fec_url":"http://docquery.fec.gov/dcdev/posted/1178702.fec","opposition_personal_funds":null,"amendment_chain":[1178702],"total_communication_cost":null,"pdf_url":"http://docquery.fec.gov/pdf/692/201708119070320692/201708119070320692.pdf","senate_personal_funds":null,"form_type":"F3","office":null,"pages":4,"is_amended":false,"primary_general_indicator":"P","candidate_name":null,"state":null,"most_recent":true,"sub_id":"4081120171446512792","amendment_indicator":"N","cash_on_hand_beginning_period":0,"beginning_image_number":"201708119070320692","fec_file_id":"FEC-1178702","report_type":"Q2","update_date":"2017-08-11T21:12:34","debts_owed_to_committee":0,"ending_image_number":"201708119070320695","html_url":"http://docquery.fec.gov/cgi-bin/forms/C00577759/1178702/","report_year":2017,"election_year":null,"party":null,"committee_id":"C00577759","coverage_start_date":"2017-04-01T00:00:00","csv_url":"http://docquery.fec.gov/csv/702/1178702.csv","request_type":null,"previous_file_number":1178702,"house_personal_funds":null,"document_description":"JULY QUARTERLY 2017","document_type_full":null,"treasurer_name":null,"cycle":2018,"total_independent_expenditures":null,"total_disbursements":0,"candidate_id":null,"file_number":1178702,"committee_name":"UBERPAC","net_donations":null,"means_filed":"e-file","amendment_version":0,"document_type":null,"total_individual_contributions":null,"report_type_full":"JULY QUARTERLY","most_recent_file_number":1178702,"cash_on_hand_end_period":0,"total_receipts":0,"coverage_end_date":"2017-06-30T00:00:00","receipt_date":"2017-08-11T00:00:00","debts_owed_by_committee":0};
  
  constructor(private router: Router) { }

  ngOnInit() {
  }
}

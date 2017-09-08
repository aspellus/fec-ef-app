import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-filings',
  templateUrl: './filings.component.html',
  styleUrls: ['./filings.component.scss']
})
export class FilingsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  
  viewFiling(committee_id, fec_file_id){
  	this.router.navigate(['/portal/filing/' + fec_file_id]);
  }

  @Input() filingData: any;
}

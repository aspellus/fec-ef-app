import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import {NgbModal, NgbActiveModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-filing',
  templateUrl: './filing.component.html',
  styleUrls: ['./filing.component.scss']
})
export class FilingComponent implements OnInit {

  constructor(private router: Router, private modalService: NgbModal) { }

  ngOnInit() {
  }

  viewFiling(committee_id, fec_file_id){
  	this.router.navigate(['/portal/filing/' + fec_file_id]);
  }

  @Input() filingData: any;
  filing: any = {};
  setFiling(rec) {
	  this.filing = rec;
  }
  
  open(content) {
    this.modalService.open(content).result.then((result) => {
      
    }, (reason) => {
      
    });
  }
}

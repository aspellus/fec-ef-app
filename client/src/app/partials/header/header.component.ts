import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import {CommitteeService} from "../../services/committee.service";

import { Committee } from '../../models/committee';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

	committees = [];
	committeeId = '';
	private _committeeIds = ['C00577759', 
	                         'C00579599',
	                         'C00615740',
	                         'C00634634',
	                         'C00650770']
	
  constructor(private route: ActivatedRoute, private committeeService: CommitteeService) {
  	this.route.params.subscribe(function (params) {
  		if (Boolean(params.committee_id)) {
  			committeeService.getOne(params.committee_id).subscribe(
				data => {
					this.committee = data.results[0];
				},
				error => console.log(error)
			);
  		}
  	}.bind(this));
  }

  ngOnInit() {
	  this._committeeIds.forEach(function each(comId){
		  this.committeeService.getOne(comId).subscribe(
				  data => {
				        this.committees.push(data.results[0]);
				      },
				      error => console.log(error)
		  );
	  }.bind(this));
  }
  
  @Input()  isLoggedIn: boolean;
  @Output() onToggleLogin = new EventEmitter<boolean>();
  
  @Input() committee: Committee;
  @Output() onSelectCommittee = new EventEmitter<Committee>();
 
  toggleLogin() {
	  this.isLoggedIn = !this.isLoggedIn;
	  this.onToggleLogin.emit(this.isLoggedIn);
  }
  
  committeeSearchById(id: string) {
	  this.committeeService.getOne(id).subscribe(
			  data => {
			        this.committee = data.results[0];
			        this.selectCommittee(this.committee);
			      },
			      error => console.log(error)
	  );
  }
  
  selectCommittee(_committee) {
	  this.committee = _committee;
	  this.onSelectCommittee.emit(this.committee);
  }
}

import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';

import {CommitteeService} from "../services/committee.service";

import { Committee } from '../models/committee';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

	committees = [];
	
  constructor(private committeeService: CommitteeService) { }

  ngOnInit() {
	  this.committeeService.getAll().subscribe(
		      data => {
		        this.committees = data.results;
		      },
		      error => console.log(error)
		    )
  }
  
  @Input()  isLoggedIn: boolean;
  @Output() onToggleLogin = new EventEmitter<boolean>();
  
  @Input() committee: Committee;
  @Output() onSelectCommittee = new EventEmitter<Committee>();
 
  toggleLogin() {
	  this.isLoggedIn = !this.isLoggedIn;
	  this.onToggleLogin.emit(this.isLoggedIn);
  }
  
  selectCommittee(_committee) {
	  this.committee = _committee;
	  this.onSelectCommittee.emit(this.committee);
  }
}

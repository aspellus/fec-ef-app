import { Component } from '@angular/core';

import { Committee } from './models/committee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
	isLoggedIn: boolean;
	committee: Committee;

	constructor(){
		this.isLoggedIn = false;
	}
	
	onToggleLogin(_isLoggedIn: boolean) {
		this.isLoggedIn = _isLoggedIn;
	}
	
	onSelectCommittee(committee: Committee) {
		this.committee = committee;
	}
}

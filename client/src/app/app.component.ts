import { Component } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { Committee } from './models/committee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
	isLoggedIn: boolean;
	committee: Committee;

	constructor(private router: Router){
		this.isLoggedIn = false;
	}
	
	onToggleLogin(_isLoggedIn: boolean) {
		this.isLoggedIn = _isLoggedIn;
		if(this.isLoggedIn){
			this.router.navigate(['/report']);
		}else{
			this.router.navigate(['/portal']);
		}
	}
	
	onSelectCommittee(committee: Committee) {
		this.committee = committee;
	}
}

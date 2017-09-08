import { Component } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
	isLoggedIn: boolean;

	constructor(private router: Router){
		this.isLoggedIn = false;
	}

	committeeLogin(id: string){
		this.isLoggedIn = true;
		this.router.navigate(['/portal/committee/' + id]);
	}
	onLogout(_isLoggedIn: boolean) {
		this.isLoggedIn = _isLoggedIn;
		this.router.navigate(['/portal']);
	}
}

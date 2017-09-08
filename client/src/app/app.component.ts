import { Component } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { CommitteeService } from "./portal/committee/committee.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
	isLoggedIn: boolean;
	committeeIds: String[] = ['C00577759','C00579599','C00615740','C00634634'];
	committees: any[] = [];
	
	constructor(private router: Router, private committeeService: CommitteeService){
		this.isLoggedIn = false;
	}

	ngOnInit(){
		this.committeeIds.forEach(function forEach(committeeId){
			this.committeeService.getOne(committeeId).subscribe(
				data => {
					this.committees.push(data.results[0]);
				},
				error => console.log(error)
			);
		}.bind(this));
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

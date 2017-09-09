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
	committeeIds: String[] = ['C00577759','C00579599','C00615740','C00634634','C00431445','C00003418'];
	committees: any[] = [];
	
	constructor(private router: Router, private committeeService: CommitteeService){
		this.router = router;
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
	
	isLoggedIn(){
		return this.router.url !== '/';
	}
	committeeLogin(id: string){
		this.router.navigate(['/committee/' + id]);
	}
	onLogout(_isLoggedIn: boolean) {
		this.router.navigate(['/']);
	}
}

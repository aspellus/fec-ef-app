import { Component, OnInit, Input } from '@angular/core';
import 'rxjs/add/operator/switchMap';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';

import { CommitteeService } from '../committee.service';

@Component({
  selector: 'app-committee-info',
  templateUrl: './committee-info.component.html',
  styleUrls: ['./committee-info.component.scss']
})
export class CommitteeInfoComponent implements OnInit {

	
  	constructor(private route: ActivatedRoute, private committeeService: CommitteeService) { }

  	ngOnInit() {
  		console.log('committee-info init');
  		
  	}
  	
  	@Input() committee: any;
}

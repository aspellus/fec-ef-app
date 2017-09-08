import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { CommitteeService } from './committee/committee.service';

@Component({
  selector: 'app-portal',
  templateUrl: './portal.component.html',
  styleUrls: ['./portal.component.css']
})
export class PortalComponent implements OnInit {

  	constructor(private router: Router, private route: ActivatedRoute, private committeeService: CommitteeService) { }

  	ngOnInit() {
  		
  	}

  
}

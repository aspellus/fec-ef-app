import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Committee } from '../../models/committee';
import { CommitteeService } from '../../services/committee.service';


@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  committee;
  
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

  ngOnInit() {}
  
  //@Input() committee: Committee;

}

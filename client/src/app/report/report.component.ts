import { Component, OnInit, Input } from '@angular/core';

import { Committee } from '../models/committee';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
  @Input() committee: Committee;

}

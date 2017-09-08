import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-filings',
  templateUrl: './filings.component.html',
  styleUrls: ['./filings.component.scss']
})
export class FilingsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() filingData: any;
}

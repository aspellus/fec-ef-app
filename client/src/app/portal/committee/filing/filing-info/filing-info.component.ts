import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-filing-info',
  templateUrl: './filing-info.component.html',
  styleUrls: ['./filing-info.component.scss']
})
export class FilingInfoComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() filing: any;
}

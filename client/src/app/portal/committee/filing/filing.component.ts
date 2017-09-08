import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-filing',
  templateUrl: './filing.component.html',
  styleUrls: ['./filing.component.scss']
})
export class FilingComponent implements OnInit {

  filing = {};
  
  constructor() { }

  ngOnInit() {
  }

}

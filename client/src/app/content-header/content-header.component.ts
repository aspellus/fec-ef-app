import { Component, OnInit, Input } from '@angular/core';

import { Committee } from '../models/committee';

@Component({
  selector: 'app-content-header',
  templateUrl: './content-header.component.html',
  styleUrls: ['./content-header.component.css']
})
export class ContentHeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() committee: Committee;
}

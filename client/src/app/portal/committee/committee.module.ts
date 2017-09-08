import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CommitteeService } from './committee.service';
import { CommitteeComponent } from './committee.component';
import { FilingsComponent } from './filings/filings.component';
import { CommitteeInfoComponent } from './committee-info/committee-info.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [CommitteeComponent, FilingsComponent, CommitteeInfoComponent],
  providers: [CommitteeService]
})
export class CommitteeModule { }

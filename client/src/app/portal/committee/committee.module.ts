import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { CommitteeService } from './committee.service';
import { CommitteeComponent } from './committee.component';
import { FilingsComponent } from './filings/filings.component';
import { CommitteeInfoComponent } from './committee-info/committee-info.component';
import { FilingComponent } from './filing/filing.component';

@NgModule({
  imports: [
    CommonModule,
    NgbModule.forRoot()
  ],
  exports: [
    CommitteeComponent,
    FilingsComponent,
    CommitteeInfoComponent
  ],
  declarations: [CommitteeComponent, FilingsComponent, CommitteeInfoComponent, FilingComponent],
  providers: [CommitteeService]
})
export class CommitteeModule { }

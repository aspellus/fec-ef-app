import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { CommitteeService } from './committee.service';
import { CommitteeComponent } from './committee.component';
import { CommitteeInfoComponent } from './committee-info/committee-info.component';
import { FilingComponent } from './filing/filing.component';
import { FilingService } from './filing/filing.service';

import { FilingInfoComponent } from './filing/filing-info/filing-info.component';


@NgModule({
  imports: [
    CommonModule,
    NgbModule.forRoot()
  ],
  exports: [
    CommitteeComponent,
    FilingComponent,
    CommitteeInfoComponent
  ],
  declarations: [CommitteeComponent, FilingComponent, CommitteeInfoComponent, FilingInfoComponent],
  providers: [CommitteeService, FilingService]
})
export class CommitteeModule { }

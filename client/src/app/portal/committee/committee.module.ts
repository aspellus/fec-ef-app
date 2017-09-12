import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CommitteeService } from './committee.service';
import { CommitteeComponent } from './committee.component';
import { CommitteeInfoComponent } from './committee-info/committee-info.component';
import { FilingsComponent } from './filings/filings.component';
import { FilingComponent } from './filing/filing.component';
import { FilingService } from './filing/filing.service';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgbModule.forRoot()
  ],
  exports: [
    CommitteeComponent,
    FilingsComponent,
    FilingComponent,
    CommitteeInfoComponent
  ],
  declarations: [CommitteeComponent, FilingsComponent, FilingComponent, CommitteeInfoComponent],
  providers: [CommitteeService, FilingService]
})
export class CommitteeModule { }

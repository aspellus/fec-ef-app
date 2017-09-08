import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { PortalComponent } from './portal.component';
import { CommitteeModule } from './committee/committee.module';

@NgModule({
  imports: [
    CommonModule,
    CommitteeModule,
    RouterModule
  ],
  exports: [
	CommitteeModule
  ],
  declarations: [
    PortalComponent
  ],
  providers: [
  ]
})
export class PortalModule { }

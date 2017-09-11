import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PortalComponent } from './portal/portal.component';
import { CommitteeComponent } from './portal/committee/committee.component';
import { CommitteeInfoComponent } from './portal/committee/committee-info/committee-info.component';
import { FilingsComponent } from './portal/committee/filings/filings.component';
import { FilingComponent } from './portal/committee/filing/filing.component';

const appRoutes: Routes = [
	{
		path: '',
		component: PortalComponent
	},
	{
		path: 'portal',
		component: PortalComponent
	},
	{
		path: 'committee/:id',
		component: CommitteeComponent,
		children: [
			{
				path: 'filings',
				component: FilingsComponent
			},
			{
				path: 'committee-info',
				component: CommitteeInfoComponent
			}
		]
	},
	{
  		path: 'committee/:id/filing/:file_id',
		component: FilingComponent
	}
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: false // <-- debugging purposes only
      }
    )
  ],
  exports: [
    RouterModule
  ],
  providers: [
    
  ]
})
export class AppRoutingModule { }

import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ReportComponent } from './modules/report/report.component';
import { PortalComponent } from './modules/portal/portal.component';

const appRoutes: Routes = [
  {
    path: 'portal',
    component: PortalComponent
  },
  {
    path: 'report',
    component: ReportComponent
  },
  {
	  path: '',
	  redirectTo: '/portal',
	  pathMatch: 'full'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: true // <-- debugging purposes only
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

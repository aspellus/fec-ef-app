import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule} from '@angular/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { CommitteeService } from './portal/committee/committee.service';
import { HeaderComponent } from './partials/header/header.component';
import { FooterComponent } from './partials/footer/footer.component';
import { PortalComponent } from './portal/portal.component';
import { ReportComponent } from './portal/report/report.component';
import { ReportFiltersComponent } from './portal/report/report-filters/report-filters.component';
import { FilingReportComponent } from './portal/report/filing-report/filing-report.component';
import { CommitteeComponent } from './portal/committee/committee.component';
import { CommitteeInfoComponent } from './portal/committee/committee-info/committee-info.component';
import { FilingsComponent } from './portal/committee/filings/filings.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PortalComponent,
    FilingReportComponent,
    ReportFiltersComponent,
    ReportComponent,
    FooterComponent,
    CommitteeInfoComponent,
    CommitteeComponent,
    FilingsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    FormsModule,
    AppRoutingModule
  ],
  providers: [CommitteeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

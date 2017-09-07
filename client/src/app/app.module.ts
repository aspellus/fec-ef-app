import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule} from '@angular/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { CommitteeService } from './services/committee.service';
import { HeaderComponent } from './partials/header/header.component';
import { FooterComponent } from './partials/footer/footer.component';
import { ContentHeaderComponent } from './partials/content-header/content-header.component';
import { PortalComponent } from './modules/portal/portal.component';
import { ReportComponent } from './modules/report/report.component';
import { ReportFiltersComponent } from './modules/report/report-filters/report-filters.component';
import { FilingReportComponent } from './modules/report/filing-report/filing-report.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PortalComponent,
    FilingReportComponent,
    ReportFiltersComponent,
    ContentHeaderComponent,
    ReportComponent,
    FooterComponent
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

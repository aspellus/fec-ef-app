import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms'; 

import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserService } from './services/user.service';
import { CommitteeService } from './services/committee.service';
import { HttpModule} from '@angular/http';
import { HeaderComponent } from './header/header.component';
import { PortalComponent } from './portal/portal.component';
import { FilingReportComponent } from './filing-report/filing-report.component';
import { ReportFiltersComponent } from './report-filters/report-filters.component';
import { ContentHeaderComponent } from './content-header/content-header.component';
import { ReportComponent } from './report/report.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
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
    FormsModule
  ],
  providers: [UserService,CommitteeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

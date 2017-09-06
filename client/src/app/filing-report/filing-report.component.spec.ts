import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilingReportComponent } from './filing-report.component';

describe('FilingReportComponent', () => {
  let component: FilingReportComponent;
  let fixture: ComponentFixture<FilingReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilingReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilingReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

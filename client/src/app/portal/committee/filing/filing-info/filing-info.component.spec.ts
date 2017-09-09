import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilingInfoComponent } from './filing-info.component';

describe('FilingInfoComponent', () => {
  let component: FilingInfoComponent;
  let fixture: ComponentFixture<FilingInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilingInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilingInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

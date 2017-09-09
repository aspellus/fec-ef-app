import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilingComponent } from './filing.component';

describe('FilingComponent', () => {
  let component: FilingComponent;
  let fixture: ComponentFixture<FilingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

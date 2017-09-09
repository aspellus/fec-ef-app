import { TestBed, inject } from '@angular/core/testing';

import { FilingService } from './filing.service';

describe('FilingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FilingService]
    });
  });

  it('should be created', inject([FilingService], (service: FilingService) => {
    expect(service).toBeTruthy();
  }));
});

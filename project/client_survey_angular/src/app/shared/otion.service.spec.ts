import { TestBed } from '@angular/core/testing';

import { OtionService } from './otion.service';

describe('OtionService', () => {
  let service: OtionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OtionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { InterheadInterceptor } from './interhead.interceptor';

describe('InterheadInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      InterheadInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: InterheadInterceptor = TestBed.inject(InterheadInterceptor);
    expect(interceptor).toBeTruthy();
  });
});

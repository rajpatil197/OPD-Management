import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { receptionAuthGuard } from './reception-auth.guard';

describe('receptionAuthGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => receptionAuthGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceptionLayoutComponent } from './reception-layout.component';

describe('ReceptionLayoutComponent', () => {
  let component: ReceptionLayoutComponent;
  let fixture: ComponentFixture<ReceptionLayoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReceptionLayoutComponent]
    });
    fixture = TestBed.createComponent(ReceptionLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailtouserComponent } from './emailtouser.component';

describe('EmailtouserComponent', () => {
  let component: EmailtouserComponent;
  let fixture: ComponentFixture<EmailtouserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmailtouserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmailtouserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

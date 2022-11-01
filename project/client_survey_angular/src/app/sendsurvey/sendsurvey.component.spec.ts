import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendsurveyComponent } from './sendsurvey.component';

describe('SendsurveyComponent', () => {
  let component: SendsurveyComponent;
  let fixture: ComponentFixture<SendsurveyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendsurveyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SendsurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

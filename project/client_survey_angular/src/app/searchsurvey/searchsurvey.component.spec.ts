import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchsurveyComponent } from './searchsurvey.component';

describe('SearchsurveyComponent', () => {
  let component: SearchsurveyComponent;
  let fixture: ComponentFixture<SearchsurveyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchsurveyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchsurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditsurveyviewComponent } from './editsurveyview.component';

describe('EditsurveyviewComponent', () => {
  let component: EditsurveyviewComponent;
  let fixture: ComponentFixture<EditsurveyviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditsurveyviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditsurveyviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

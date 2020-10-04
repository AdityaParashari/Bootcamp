import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AirportScheduleComponent } from './airport-schedule.component';

describe('AirportScheduleComponent', () => {
  let component: AirportScheduleComponent;
  let fixture: ComponentFixture<AirportScheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AirportScheduleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AirportScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

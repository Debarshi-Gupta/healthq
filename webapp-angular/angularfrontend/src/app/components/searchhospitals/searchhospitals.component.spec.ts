import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchhospitalsComponent } from './searchhospitals.component';

describe('SearchhospitalsComponent', () => {
  let component: SearchhospitalsComponent;
  let fixture: ComponentFixture<SearchhospitalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchhospitalsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchhospitalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

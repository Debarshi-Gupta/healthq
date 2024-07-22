import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MembervalidationComponent } from './membervalidation.component';

describe('MembervalidationComponent', () => {
  let component: MembervalidationComponent;
  let fixture: ComponentFixture<MembervalidationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MembervalidationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MembervalidationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

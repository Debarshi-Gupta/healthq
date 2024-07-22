import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberregistrationComponent } from './memberregistration.component';

describe('MemberregistrationComponent', () => {
  let component: MemberregistrationComponent;
  let fixture: ComponentFixture<MemberregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MemberregistrationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MemberregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberdetailsupdateComponent } from './memberdetailsupdate.component';

describe('MemberdetailsupdateComponent', () => {
  let component: MemberdetailsupdateComponent;
  let fixture: ComponentFixture<MemberdetailsupdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MemberdetailsupdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MemberdetailsupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

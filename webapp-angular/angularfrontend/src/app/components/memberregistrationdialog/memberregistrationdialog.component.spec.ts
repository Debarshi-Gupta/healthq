import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberregistrationdialogComponent } from './memberregistrationdialog.component';

describe('MemberregistrationdialogComponent', () => {
  let component: MemberregistrationdialogComponent;
  let fixture: ComponentFixture<MemberregistrationdialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MemberregistrationdialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MemberregistrationdialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberdetailsupdatedialogComponent } from './memberdetailsupdatedialog.component';

describe('MemberdetailsupdatedialogComponent', () => {
  let component: MemberdetailsupdatedialogComponent;
  let fixture: ComponentFixture<MemberdetailsupdatedialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MemberdetailsupdatedialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MemberdetailsupdatedialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

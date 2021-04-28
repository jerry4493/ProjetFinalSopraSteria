import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidecongeEditComponent } from './valideconge-edit.component';

describe('ValidecongeEditComponent', () => {
  let component: ValidecongeEditComponent;
  let fixture: ComponentFixture<ValidecongeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ValidecongeEditComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValidecongeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

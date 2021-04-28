import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandecongeEditComponent } from './demandeconge-edit.component';

describe('DemandecongeEditComponent', () => {
  let component: DemandecongeEditComponent;
  let fixture: ComponentFixture<DemandecongeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemandecongeEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandecongeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

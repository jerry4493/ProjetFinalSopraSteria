import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandecongeListComponent } from './demandeconge-list.component';

describe('DemandecongeListComponent', () => {
  let component: DemandecongeListComponent;
  let fixture: ComponentFixture<DemandecongeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemandecongeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandecongeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

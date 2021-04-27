import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidecongeListComponent } from './valideconge-list.component';

describe('ValidecongeListComponent', () => {
  let component: ValidecongeListComponent;
  let fixture: ComponentFixture<ValidecongeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValidecongeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValidecongeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

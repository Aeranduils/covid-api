import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorInfosComponent } from './error-infos.component';

describe('ErrorInfosComponent', () => {
  let component: ErrorInfosComponent;
  let fixture: ComponentFixture<ErrorInfosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ErrorInfosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErrorInfosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

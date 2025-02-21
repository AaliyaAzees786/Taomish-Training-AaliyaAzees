import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomBindComponent } from './custom-bind.component';

describe('CustomBindComponent', () => {
  let component: CustomBindComponent;
  let fixture: ComponentFixture<CustomBindComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CustomBindComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomBindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

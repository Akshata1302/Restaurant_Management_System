import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRestaurantComponent } from './update-restaurant.component';

describe('UpdateRestaurantComponent', () => {
  let component: UpdateRestaurantComponent;
  let fixture: ComponentFixture<UpdateRestaurantComponent>;

  beforeEach(() => {
     TestBed.configureTestingModule({
      declarations: [UpdateRestaurantComponent]
    });
   

    fixture = TestBed.createComponent(UpdateRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

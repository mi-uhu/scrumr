import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebPresenceComponent } from './web-presence.component';

describe('WebPresenceComponent', () => {
  let component: WebPresenceComponent;
  let fixture: ComponentFixture<WebPresenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WebPresenceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WebPresenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

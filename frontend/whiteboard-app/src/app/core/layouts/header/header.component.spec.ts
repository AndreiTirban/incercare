import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderComponent } from './header.component';
import { DebugElement } from "@angular/core";

describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;
  let de: DebugElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderComponent ]
    }).compileComponents();

      fixture = TestBed.createComponent(HeaderComponent);
      component = fixture.componentInstance;
      de = fixture.debugElement;
      fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('renders an image component', () => {
    expect(de.nativeElement.querySelector('app-image')).toBeTruthy();
  });
});

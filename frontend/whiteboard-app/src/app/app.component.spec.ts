import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  let app: AppComponent;
  let fixture: ComponentFixture<AppComponent>;
  let de: DebugElement;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(AppComponent);
    app = fixture.componentInstance;
    de = fixture.debugElement;
    fixture.detectChanges();

  });

  it('should create the app', () => {
    expect(app).toBeTruthy();
  });

  it('renders a header component', () => {
    expect(de.nativeElement.querySelector('app-header')).toBeTruthy();
  });
});

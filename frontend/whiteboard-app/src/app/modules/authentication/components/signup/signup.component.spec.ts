import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { SignupComponent } from './signup.component';

describe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;
  let de: DebugElement;
  const buttonComponent = 'app-button';
  const imageComponent = 'app-image';
  const signupFormComponent = 'app-signup-form'

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        SignupComponent,
      ],
    })
      .compileComponents();

    fixture = TestBed.createComponent(SignupComponent);
    component = fixture.componentInstance;
    de = fixture.debugElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('Html checks', function () {
    it('should have an h1 tag of `Whiteboard`', () => {
      expect(de.query(By.css('h1')).nativeElement.innerText).toBe('Whiteboard');
    });
    it('should have an h2 tag of `Collaborative`', () => {
      expect(de.query(By.css('h2')).nativeElement.innerText).toBe('Collaborative');
    });
    it('should have a p of `Already a member? Login here.`', () => {
      expect(de.query(By.css('p')).nativeElement.innerText).toBe('Already a member? Login here.');
    });

  });

  describe('Components that should render', function () {
    it('renders a button component', () => {
      expect(de.nativeElement.querySelector(buttonComponent)).toBeTruthy();
    });
    it('renders an image component', () => {
      expect(de.nativeElement.querySelector(imageComponent)).toBeTruthy();
    });
    it('renders a signup form component', () => {
      expect(de.nativeElement.querySelector(signupFormComponent)).toBeTruthy();
    });
  });

  describe('Children components properties check', function () {
    it('passes the text `Login`` to the button component', () => {
      const button = de.query(By.css(buttonComponent));
      expect(button.properties.text).toBe('Login');
    });
    it('passes the class `btn-md`` to the button component', () => {
      const button = de.query(By.css(buttonComponent));
      expect(button.properties.buttonSize).toBe('btn-md');
    });
    it('passes the alt text `Board image` to the image component', () => {
      const button = de.query(By.css(imageComponent));
      expect(button.properties.altText).toBe('Board image');
    });
  });
});

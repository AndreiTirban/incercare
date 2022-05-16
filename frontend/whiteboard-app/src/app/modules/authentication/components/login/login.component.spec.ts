import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';
import { DebugElement } from "@angular/core";
import { By } from "@angular/platform-browser";

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de: DebugElement;
  const buttonComponent = 'app-button';
  const imageComponent = 'app-image';
  const loginFormComponent = 'app-login-form'

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        LoginComponent,
      ],
    })
      .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
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
    it('should have a p of `Don\'t have an account? Sign-up now!`', () => {
      expect(de.query(By.css('p')).nativeElement.innerText).toBe('Don\'t have an account? Sign-up now!');
    });
  });

  describe('Components that should render', function () {
    it('renders a button component', () => {
      expect(de.nativeElement.querySelector(buttonComponent)).toBeTruthy();
    });
    it('renders an image component', () => {
      expect(de.nativeElement.querySelector(imageComponent)).toBeTruthy();
    });
    it('renders a login form component', () => {
      expect(de.nativeElement.querySelector(loginFormComponent)).toBeTruthy();
    });
  });

  describe('Children components properties check', function () {
    it('passes the text `Create account` to the button component', () => {
      const button = de.query(By.css(buttonComponent));
      expect(button.properties.text).toBe('Create account');
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

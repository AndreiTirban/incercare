import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginFormComponent } from './login-form.component';
import { DebugElement } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { By } from "@angular/platform-browser";

describe('LoginFormComponent', () => {
  let component: LoginFormComponent;
  let fixture: ComponentFixture<LoginFormComponent>;
  let debugElement: DebugElement;
  const validPassword = 'Test123!';
  const validEmail = 'test@test.com';
  const emailControl = 'email';
  const passwordControl = 'password';
  const formFieldComponent = 'app-form-field';
  const buttonComponent = 'app-button';
  const requiredError = 'required';
  const patternError = 'pattern';

  beforeEach(async () => {
    await TestBed
      .configureTestingModule({
        providers: [
          LoginFormComponent
        ],
        imports: [
          ReactiveFormsModule,
        ],
        declarations: [
          LoginFormComponent,
        ],
      })
      .compileComponents();

    fixture = TestBed.createComponent(LoginFormComponent);
    component = fixture.componentInstance;
    debugElement = fixture.debugElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('Email form field', function () {
    it('form field for email should have an icon of `envelope`', () => {
      const formField = debugElement.queryAll(By.css(formFieldComponent));
      expect(formField[0].properties.iconName).toBe('envelope');
    });
    it('email field validity before entering data', () => {
      let email = component.form.controls[emailControl];
      email.setValue('');
      expect(email.valid).toBeFalsy();
      expect(email.errors).not.toBeNull();
    });
    it('email field validity after entering data', () => {
      let email = component.form.controls[emailControl];

      email.setValue('');
      expect(email.hasError(requiredError)).toBeTruthy();

      email.setValue('test');
      expect(email.hasError(patternError)).toBeTruthy();

      email.setValue(validEmail);
      expect(email.hasError(patternError)).toBeFalsy();
    });
  });

  describe('Password form field', function () {
    it('form field for password should have an icon of `lock`', () => {
      const formField = debugElement.queryAll(By.css(formFieldComponent));
      expect(formField[1].properties.iconName).toBe('lock');
    });
    it('password field validity before entering data', () => {
      let password = component.form.controls[passwordControl];
      password.setValue('');
      expect(password.valid).toBeFalsy();
      expect(password.errors).not.toBeNull();
    });
    it('password field validity after entering data', () => {
      let password = component.form.controls[passwordControl];

      password.setValue('');
      expect(password.hasError(requiredError)).toBeTruthy();
      password.setValue(validPassword);
      expect(password.hasError(requiredError)).toBeFalsy();

    });
  });

  describe('Children components', function () {
    it('should render a button component', () => {
      expect(debugElement.nativeElement.querySelector(buttonComponent)).toBeTruthy();
    });
    it('should render 2 form fields', () => {
      const inputs = debugElement.queryAll(By.css(formFieldComponent));
      expect(inputs.length).toEqual(2);
    });
    it('passes the text `Create account` to the button component', () => {
      const button = debugElement.query(By.css(buttonComponent));
      expect(button.properties.text).toBe('Login');
    });
  });

  describe('Form validity', function () {
    it('Check initial form values for signup form', () => {
      const loginForm = component.form;
      const loginFormValues = {
        email: '',
        password: '',
      }
      expect(loginForm.value).toEqual(loginFormValues);
    });
    it('Check form invalid when empty', () => {
      expect(component.form.valid).toBeFalsy();
    });
    it('Check submitting the form', () => {
      expect(component.form.valid).toBeFalsy();
      component.form.controls[emailControl].setValue(validEmail);
      component.form.controls[passwordControl].setValue(validPassword);
      expect(component.form.valid).toBeTruthy();
      component.onSubmit();
      expect(component.submitted).toBeTruthy();
    });
  });
});

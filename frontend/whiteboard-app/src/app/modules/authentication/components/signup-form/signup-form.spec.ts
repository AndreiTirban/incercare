import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { SignupForm } from './signup-form';

describe('SignupForm', () => {
  let component: SignupForm;
  let fixture: ComponentFixture<SignupForm>;
  let debugElement: DebugElement;
  const validPassword = 'Test123!';
  const validName = 'testname';
  const validEmail = 'test@test.com';
  const nameControl = 'fullName';
  const emailControl = 'email';
  const passwordControl = 'password';
  const confirmControl = 'confirmPassword';
  const formFieldComponent = 'app-form-field';
  const buttonComponent = 'app-button';
  const requiredError = 'required';
  const patternError = 'pattern';
  const matchingError = 'matching';
  const minLengthError = 'minlength';
  const maxLengthError = 'maxlength';
  const digitError = 'digitValidation';
  const specialCharError = 'specialCharacter';
  const lowercaseLetterError = 'lowercaseLetter';
  const uppercaseLetterError = 'uppercaseLetter';

  beforeEach(async () => {
    await TestBed
      .configureTestingModule({
        providers: [
          SignupForm
        ],
        imports: [
          ReactiveFormsModule,
        ],
        declarations: [
          SignupForm,
        ],
      })
      .compileComponents();

    fixture = TestBed.createComponent(SignupForm);
    component = fixture.componentInstance;
    debugElement = fixture.debugElement;
    fixture.detectChanges();

  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('Name form field', function () {
    it('form field for user name should have an icon of `user`', () => {
      const formField = debugElement.queryAll(By.css(formFieldComponent));
      expect(formField[0].properties.iconName).toBe('user');
    });
    it('fullName field validity before entering data', () => {
      let fullName = component.form.controls[nameControl];
      fullName.setValue('');
      expect(fullName.valid).toBeFalsy();
      expect(fullName.errors).not.toBeNull();
    });
    it('fullName field validity after entering data', () => {
      let fullName = component.form.controls[nameControl];

      fullName.setValue('');
      expect(fullName.hasError(requiredError)).toBeTruthy();

      fullName.setValue('1');
      expect(fullName.hasError(patternError)).toBeTruthy();
      expect(fullName.hasError(minLengthError)).toBeTruthy();

      fullName.setValue(validName);
      expect(fullName.hasError(patternError)).toBeFalsy();
      expect(fullName.hasError(minLengthError)).toBeFalsy();
    });
  });

  describe('Email form field', function () {
    it('form field for email should have an icon of `envelope`', () => {
      const formField = debugElement.queryAll(By.css(formFieldComponent));
      expect(formField[1].properties.iconName).toBe('envelope');
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
      expect(formField[2].properties.iconName).toBe('lock');
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

      password.setValue('T');
      expect(password.hasError(minLengthError)).toBeTruthy();
      expect(password.hasError(lowercaseLetterError)).toBeTruthy();
      expect(password.hasError(digitError)).toBeTruthy();
      expect(password.hasError(specialCharError)).toBeTruthy();
      expect(password.hasError(maxLengthError)).toBeFalsy();

      password.setValue('testtesttesttesttesttesttesttesttesttesttesttest');
      expect(password.hasError(uppercaseLetterError)).toBeTruthy();
      expect(password.hasError(maxLengthError)).toBeTruthy();

      password.setValue(validPassword);
      expect(password.hasError(requiredError)).toBeFalsy();
      expect(password.hasError(minLengthError)).toBeFalsy();
      expect(password.hasError(maxLengthError)).toBeFalsy();
      expect(password.hasError(digitError)).toBeFalsy();
      expect(password.hasError(specialCharError)).toBeFalsy();
      expect(password.hasError(lowercaseLetterError)).toBeFalsy();
      expect(password.hasError(uppercaseLetterError)).toBeFalsy();
    });
  });

  describe('Confirm password form field', function () {
    it('form field for password confirmation should have an icon of `lock`', () => {
      const formField = debugElement.queryAll(By.css(formFieldComponent));
      expect(formField[3].properties.iconName).toBe('lock');
    });
    it('confirmPassword field validity before entering data', () => {
      let confirmPassword = component.form.controls[confirmControl];
      confirmPassword.setValue('');
      expect(confirmPassword.valid).toBeFalsy();
      expect(confirmPassword.errors).not.toBeNull();
    });
    it('confirmPassword field validity after entering data', () => {
      let confirmPassword = component.form.controls[confirmControl];
      confirmPassword.setValue('');
      expect(confirmPassword.hasError(requiredError)).toBeTruthy();
    });
    it('Confirm passwords match', () => {
      let confirmPassword = component.form.controls[confirmControl];
      let password = component.form.controls[passwordControl];

      confirmPassword.setValue(validPassword);
      password.setValue('Test1234!');
      expect(confirmPassword.hasError(matchingError)).toBeTruthy();

      confirmPassword.setValue(validPassword);
      password.setValue(validPassword);
      expect(confirmPassword.hasError(matchingError)).toBeFalsy();
    });
  });

  describe('Children components', function () {
    it('should render a button component', () => {
      expect(debugElement.nativeElement.querySelector(buttonComponent)).toBeTruthy();
    });
    it('should render 4 form fields', () => {
      const inputs = debugElement.queryAll(By.css(formFieldComponent));
      expect(inputs.length).toEqual(4);
    });
    it('passes the text `Create account` to the button component', () => {
      const button = debugElement.query(By.css(buttonComponent));
      expect(button.properties.text).toBe('Create account');
    });
  });

  describe('Form validity', function () {
    it('Check initial form values for signup form', () => {
      const signupForm = component.form;
      const signupFormValues = {
        fullName: '',
        email: '',
        password: '',
        confirmPassword: ''
      }
      expect(signupForm.value).toEqual(signupFormValues);
    });
    it('Check form invalid when empty', () => {
      expect(component.form.valid).toBeFalsy();
    });
    it('Check submitting the form', () => {
      expect(component.form.valid).toBeFalsy();
      component.form.controls[nameControl].setValue(validName);
      component.form.controls[emailControl].setValue(validEmail);
      component.form.controls[passwordControl].setValue(validPassword);
      component.form.controls[confirmControl].setValue(validPassword);
      expect(component.form.valid).toBeTruthy();
      component.onSubmit();
      expect(component.submitted).toBeTruthy();
    });
  });
});

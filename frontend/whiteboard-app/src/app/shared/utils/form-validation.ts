// @ts-nocheck

import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class FormValidation {
  static match(controlName: string, checkControlName: string): ValidatorFn {
    return (controls: AbstractControl) => {
      const control = controls.get(controlName);
      const checkControl = controls.get(checkControlName);
      if (checkControl.errors && !checkControl.errors.matching) {
        return null;
      }
      if (control.value !== checkControl.value) {
        controls.get(checkControlName).setErrors({ matching: true });
        return { matching: true };
      } else {
        controls.get(checkControlName).setErrors(null);
        return null;
      }
    };
  }
}

export function uppercaseLetter(validatorRegex: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const uppercase = validatorRegex.test(control.value);
    return !uppercase ? { uppercaseLetter: { value: control.value } } : null;
  };
}

export function lowercaseLetter(validatorRegex: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const lowercase = validatorRegex.test(control.value);
    return !lowercase ? { lowercaseLetter: { value: control.value } } : null;
  };
}

export function digitValidation(validatorRegex: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const digit = validatorRegex.test(control.value);
    return !digit ? { digitValidation: { value: control.value } } : null;
  };
}

export function specialCharacter(validatorRegex: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const special = validatorRegex.test(control.value);
    return !special ? { specialCharacter: { value: control.value } } : null;
  };
}

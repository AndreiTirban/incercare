import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { digitValidation, FormValidation, lowercaseLetter, specialCharacter, uppercaseLetter } from 'src/app/shared';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.html',
  styleUrls: [ './signup-form.sass' ]
})
export class SignupForm implements OnInit {
  form: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) {
  }

  get getFormControls(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.form = this.formBuilder.group(
      {
        fullName: [ '',
          [
            Validators.minLength(8),
            Validators.required,
            Validators.pattern(/^[a-zA-Z]+$/)
          ]

        ],
        email: [ '',
          [
            Validators.required,
            Validators.pattern(/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/)
          ]
        ]
        ,
        password: [ '',
          [
            Validators.required,
            Validators.minLength(8),
            Validators.maxLength(30),
            uppercaseLetter(/[A-Z]+/),
            lowercaseLetter(/[a-z]+/),
            digitValidation(/\d+/),
            specialCharacter(/[!?@#$%^&*_=+-]/)
          ]
        ],
        confirmPassword: [ '',
          [
            Validators.required,
            Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*_=+-]).{6,40}$/)
          ]
        ]
      },
      {
        validators: [ FormValidation.match('password', 'confirmPassword') ]
      }
    );
  }

  onSubmit(): void {
    this.submitted = true;
  }
}
